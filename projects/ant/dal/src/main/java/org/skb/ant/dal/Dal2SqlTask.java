/* Copyright (c) 2011-2011 Sven van der Meer (sven@vandermeer.de)
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
 *       documentation and/or other materials provided with the distribution.
 *     + Neither the name of the the author nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS  IS"
 * AND ANY EXPRESS  OR IMPLIED WARRANTIES,  INCLUDING, BUT NOT  LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY  AND FITNESS FOR A  PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN  NO EVENT SHALL  THE COPYRIGHT HOLDER  OR CONTRIBUTORS BE
 * LIABLE  FOR  ANY  DIRECT,  INDIRECT,  INCIDENTAL,  SPECIAL,  EXEMPLARY,   OR
 * CONSEQUENTIAL  DAMAGES  (INCLUDING,  BUT  NOT  LIMITED  TO,  PROCUREMENT  OF
 * SUBSTITUTE GOODS  OR SERVICES;  LOSS OF  USE, DATA,  OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER  CAUSED AND  ON ANY  THEORY OF  LIABILITY, WHETHER  IN
 * CONTRACT,  STRICT LIABILITY,  OR TORT  (INCLUDING NEGLIGENCE  OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE  USE OF THIS SOFTWARE, EVEN IF ADVISED  OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 */

package org.skb.ant.dal;

import java.util.Iterator;
import java.util.Vector;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;
import org.skb.lang.dal.Dal;

/**
 * Ant task for converting DAL to SQL
 *
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v1.0.0 build 110901 (01-Sep-11) with Java 1.6
 */
public class Dal2SqlTask extends Task {
	private Vector<FileSet> filesets = new Vector<FileSet>();
	private String destdir=null;

    public void setDestdir(String s){
        this.destdir=s;
    }

    public void addFileset(FileSet fileset) {
        filesets.add(fileset);
    }

    public void execute() throws BuildException {
    	if(this.filesets.size()==0)
    		throw new BuildException("no fileset given, nothing to do");
    	if(this.destdir==null)
    		throw new BuildException("no destination directory given");

        for(Iterator<FileSet> itFSets=filesets.iterator(); itFSets.hasNext();){
            FileSet fs=(FileSet)itFSets.next();
            DirectoryScanner ds=fs.getDirectoryScanner(getProject());
            String[] includedFiles=ds.getIncludedFiles();
            for(int i=0; i<includedFiles.length; i++){
            	String filename=includedFiles[i].replace('\\','/');
                //filename = filename.substring(filename.lastIndexOf("/")+1);
                String dir=ds.getBasedir().getAbsolutePath();
                dir=dir.replace('\\','/');

                System.err.println("converting "+filename);
                Dal.main(new String[]{"--src-lang", "dal", "--tgt-lang", "sql", "--no-warnings", "--gc", "--tgt-dir", this.destdir, "--src-file", dir+"/"+filename});
            }
        }
    }
}
