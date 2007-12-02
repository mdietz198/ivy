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
package org.apache.ivy.core.report;

import java.io.File;

import org.apache.ivy.core.cache.ArtifactOrigin;
import org.apache.ivy.core.module.descriptor.Artifact;

/**
 * Report on the download of an artifact from a repository to a local (cached) file.
 * <p>
 * Note that depending on cache implementation, the artifact may not be actually downloaded, but
 * used directly from its original location.
 * </p>
 */
public class ArtifactDownloadReport {
    private Artifact artifact;

    private ArtifactOrigin origin;
    
    private File downloadedFile;

    private DownloadStatus downloadStatus;

    private long size;

    private String downloadDetails = "";

    private long downloadTimeMillis;

    public ArtifactDownloadReport(Artifact artifact) {
        this.artifact = artifact;
    }

    public DownloadStatus getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(DownloadStatus downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public String getName() {
        return artifact.getName();
    }

    public String getType() {
        return artifact.getType();
    }

    public Artifact getArtifact() {
        return artifact;
    }

    public String getExt() {
        return artifact.getExt();
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setArtifactOrigin(ArtifactOrigin origin) {
        this.origin = origin;
    }

    public ArtifactOrigin getArtifactOrigin() {
        return origin;
    }

    public void setDownloadDetails(String message) {
        downloadDetails = message;
    }
    
    public String getDownloadDetails() {
        return downloadDetails;
    }

    public void setDownloadTimeMillis(long l) {
        downloadTimeMillis = l;
    }
    
    public long getDownloadTimeMillis() {
        return downloadTimeMillis;
    }
    
    public String toString() {
        if (downloadStatus == DownloadStatus.SUCCESSFUL) {
            return "[SUCCESSFUL ] " + artifact + " (" + downloadTimeMillis + "ms)";
        } else if (downloadStatus == DownloadStatus.FAILED) {
            return "[FAILED     ] " + artifact + " : " + downloadDetails
                + " (" + downloadTimeMillis + "ms)";
        } else if (downloadStatus == DownloadStatus.NO) {
            return "[NOT REQUIRED] " + artifact;
        } else {
            return super.toString();
        }
    }

    /**
     * Returns the file where the artifact has been downloaded, or <code>null</code> if and only
     * if the download failed.
     * 
     * @return the file where the artifact has been downloaded
     */
    public File getDownloadedFile() {
        return downloadedFile;
    }

    public void setDownloadedFile(File downloadedFile) {
        this.downloadedFile = downloadedFile;
    }
}