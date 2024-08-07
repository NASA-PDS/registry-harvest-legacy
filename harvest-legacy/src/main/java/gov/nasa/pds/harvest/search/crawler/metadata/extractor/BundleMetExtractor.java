package gov.nasa.pds.harvest.search.crawler.metadata.extractor;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import gov.nasa.pds.harvest.search.constants.Constants;
import gov.nasa.pds.harvest.search.inventory.ReferenceEntry;
import gov.nasa.pds.harvest.search.logging.ToolsLevel;
import gov.nasa.pds.harvest.search.logging.ToolsLogRecord;
import gov.nasa.pds.harvest.search.oodt.filemgr.exceptions.MetExtractionException;
import gov.nasa.pds.harvest.search.oodt.metadata.Metadata;
import gov.nasa.pds.registry.model.Slot;
import net.sf.saxon.tree.tiny.TinyElementImpl;

/**
 * Class that extracts metadata from a PDS Bundle file.
 *
 * @author mcayanan
 *
 */
public class BundleMetExtractor extends Pds4MetExtractor {
  /** Logger object. */
  private static Logger log = Logger.getLogger(
      BundleMetExtractor.class.getName());

  /**
   * Constructor.
   *
   * @param config A configuration to do metadata extraction.
   */
  public BundleMetExtractor(Pds4MetExtractorConfig config) {
    super(config);
  }

  /**
   * Extract the metadata.
   *
   * @param product A PDS4 collection file
   * @return a class representation of the extracted metadata
   *
   */
  public Metadata extractMetadata(File product)
  throws MetExtractionException {
    Metadata metadata = new Metadata();
    String objectType = "";
    String logicalID = "";
    String version = "";
    String title = "";
    List<TinyElementImpl> references = new ArrayList<TinyElementImpl>();
    List<Slot> slots = new ArrayList<Slot>();
    try {
      extractor.parse(product);
    } catch (Exception e) {
      throw new MetExtractionException("Parse failure: " + e.getMessage());
    }
    try {
      objectType = extractor.getValueFromDoc(Constants.coreXpathsMap.get(
          Constants.PRODUCT_CLASS));
      logicalID = extractor.getValueFromDoc(Constants.coreXpathsMap.get(
          Constants.LOGICAL_ID));
      version = extractor.getValueFromDoc(Constants.coreXpathsMap.get(
          Constants.PRODUCT_VERSION));
      title = extractor.getValueFromDoc(Constants.coreXpathsMap.get(
          Constants.TITLE));
      references = extractor.getNodesFromDoc(Constants.coreXpathsMap.get(
          Constants.REFERENCES));
    } catch (Exception x) {
      //TODO: getMessage() doesn't always return a message
      throw new MetExtractionException(x.getMessage());
    }
    if (!"".equals(logicalID)) {
      metadata.addMetadata(Constants.LOGICAL_ID, logicalID);
    }
    if (!"".equals(version)) {
      metadata.addMetadata(Constants.PRODUCT_VERSION, version);
    }
    if (!"".equals(title)) {
      String trimmedTitle = title.replaceAll("\\s+", " ").trim();
      metadata.addMetadata(Constants.TITLE, trimmedTitle);
    }
    if (!"".equals(objectType)) {
      metadata.addMetadata(Constants.OBJECT_TYPE, objectType);
    }
    if (references.size() == 0) {
      log.log(new ToolsLogRecord(ToolsLevel.DEBUG, "No associations found.",
          product));
    }
    if ((!"".equals(objectType)) && (config.hasObjectType(objectType))) {
      slots.addAll(extractMetadata(config.getMetXPaths(objectType)));
    }
    try {
      HashMap<String, List<String>> refMap =
          new HashMap<String, List<String>>();
      // Register LID-based and LIDVID-based associations as slots
      for (ReferenceEntry entry : getReferences(references, product)) {
        String value = "";
        if (!entry.hasVersion()) {
          log.log(new ToolsLogRecord(ToolsLevel.DEBUG, "Setting "
              + "LID-based association, \'" + entry.getLogicalID()
              + "\', under slot name \'" + entry.getType()
              + "\'.", product));
          value = entry.getLogicalID();
        } else {
          String lidvid = entry.getLogicalID() + "::" + entry.getVersion();
          log.log(new ToolsLogRecord(ToolsLevel.DEBUG, "Setting "
              + "LIDVID-based association, \'" + lidvid
              + "\', under slot name \'" + entry.getType()
              + "\'.", product));
          value = lidvid;
        }
        List<String> values = refMap.get(entry.getType());
        if (values == null) {
          values = new ArrayList<String>();
          refMap.put(entry.getType(), values);
          values.add(value);
        } else {
          values.add(value);
        }
      }
      if (!refMap.isEmpty()) {
        for (Map.Entry<String, List<String>> entry : refMap.entrySet()) {
          slots.add(new Slot(entry.getKey(), entry.getValue()));
        }
      }
    } catch (Exception e) {
      throw new MetExtractionException(e.getMessage());
    }
    if (!slots.isEmpty()) {
      metadata.addMetadata(Constants.SLOT_METADATA, slots);
    }
    return metadata;
  }
}
