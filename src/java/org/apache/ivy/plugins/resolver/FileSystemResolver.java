/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.ivy.plugins.resolver;

import org.apache.ivy.plugins.repository.file.FileRepository;

/**
 * @author Xavier Hanin
 */
public class FileSystemResolver extends RepositoryResolver {
    public FileSystemResolver() {
        setRepository(new FileRepository());
    }
    public String getTypeName() {
        return "file";
    }
	public boolean isLocal() {
		return getFileRepository().isLocal();
	}

	public void setLocal(boolean local) {
		getFileRepository().setLocal(local);
	}
	private FileRepository getFileRepository() {
		return (FileRepository) getRepository();
	}
    
}