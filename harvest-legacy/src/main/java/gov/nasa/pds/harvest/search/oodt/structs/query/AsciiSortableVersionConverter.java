/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package gov.nasa.pds.harvest.search.oodt.structs.query;

/**
 * 
 * @author bfoster
 * @version $Revision$
 *
 *          <p>
 *          Converts a ascii sortable String version into a priority number
 *          <p>
 */
public class AsciiSortableVersionConverter implements VersionConverter {

  public double convertToPriority(String version) {
    double priority = 0;
    char[] versionCharArray = version.toCharArray();
    for (int i = 0, j = versionCharArray.length - 1; i < versionCharArray.length; i++, j--) {
      priority += (((int) versionCharArray[i]) * Math.pow(10, j));
    }
    return priority;
  }

}
