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

package gov.nasa.pds.harvest.search.oodt.filemgr.exceptions;

/**
 * @author mattmann
 * @version $Revision$
 * 
 *          <p>
 *          An exception thrown from the
 *          {@link org.apache.oodt.cas.filemgr.repository.RepositoryManager} interface.
 *          </p>
 * 
 */
public class RepositoryManagerException extends Exception {

  private static final long serialVersionUID = 3688502208018920497L;

  /**
   * 
   */
  public RepositoryManagerException() {
    super();
  }

  /**
   * @param message
   */
  public RepositoryManagerException(String message) {
    super(message);
  }

  public RepositoryManagerException(Throwable t) {
    super(t);
  }

  public RepositoryManagerException(String message, Throwable t) {
    super(message, t);
  }
}
