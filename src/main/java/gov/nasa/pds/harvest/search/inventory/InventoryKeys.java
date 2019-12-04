// Copyright 2019, California Institute of Technology ("Caltech").
// U.S. Government sponsorship acknowledged.
//
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// * Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.
// * Redistributions must reproduce the above copyright notice, this list of
// conditions and the following disclaimer in the documentation and/or other
// materials provided with the distribution.
// * Neither the name of Caltech nor its operating division, the Jet Propulsion
// Laboratory, nor the names of its contributors may be used to endorse or
// promote products derived from this software without specific prior written
// permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.

package gov.nasa.pds.harvest.search.inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * Class containing XPaths used when reading a PDS4 Inventory file.
 *
 * @author mcayanan
 *
 */
public class InventoryKeys {

  /**
   * XPath to determine the field delimiter being used in the inventory table.
   */
  public static final String FIELD_DELIMITER_XPATH = "//Inventory/field_delimiter";

  /**
   * XPath to determine the field location of the member status field in the
   * inventory table.
   */
  public static final String MEMBER_STATUS_FIELD_NUMBER_XPATH =
      "//Inventory/Record_Delimited/Field_Delimited[name='Member_Status' or name='Member Status']/field_number";

  /**
   * XPath to determine the field location of the LID-LIDVID field in the
   * inventory table.
   */
  public static final String LIDVID_LID_FIELD_NUMBER_XPATH =
    "//Inventory/Record_Delimited/Field_Delimited[data_type='ASCII_LIDVID_LID']/field_number";

  /** XPath to the external table file of a collection. */
  public static final String DATA_FILE_XPATH = "//*[starts-with(name(),"
    + "'File_Area')]/File/file_name";

  /** XPath to grab the Member_Entry tags in a bundle. */
  public static final String MEMBER_ENTRY_XPATH =
    "//*[ends-with(name(),'Member_Entry')]";

  /** The MD5 checksum XPath in an Inventory file. */
  public static final String CHECKSUM_XPATH = "md5_checksum";

  /** The member status XPath in an Inventory file. */
  public static final String MEMBER_STATUS_XPATH = "member_status";

  /** The LID-VID or LID XPath for an association. */
  public static final String IDENTITY_REFERENCE_XPATH =
      "lidvid_reference | lid_reference";

  public static final Map<String, String> fieldDelimiters =
    new HashMap<String, String>();

  static {
    fieldDelimiters.put("comma",",");
    fieldDelimiters.put("horizontal_tab", "\\t");
    fieldDelimiters.put("semicolon", ";");
    fieldDelimiters.put("vertical_bar", "\\|");
  }
}
