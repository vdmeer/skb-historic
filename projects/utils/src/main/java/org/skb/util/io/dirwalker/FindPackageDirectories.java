/* Copyright (c) 2010-2011 Sven van der Meer
 * All rights reserved.
 *
 * Redistribution  and  use  in  source  and  binary  forms,  with  or  without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     + Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     + Redistributions  in binary  form must  reproduce the  above copyright
 *       notice, this list  of conditions and  the following disclaimer  in the
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

package org.skb.util.io.dirwalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang.StringUtils;

/**
 * Walk a directory and find entries, specifically for the SKB.
 *  
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @version    v0.20 build 110309 (09-Mar-11) with Java 1.6
 */
@SuppressWarnings(value={"all"})
public class FindPackageDirectories extends DirectoryWalker {
	private String site_id;

//    private static IOFileFilter filter = FileFilterUtils.and(FileFilterUtils.fileFileFilter(),
//            FileFilterUtils.suffixFileFilter(".json"));
	private static IOFileFilter filter = 
        FileFilterUtils.and(FileFilterUtils.directoryFileFilter(), HiddenFileFilter.VISIBLE);

	public FindPackageDirectories() {
		super(filter, -1);
		this.site_id="";
	}

	public void siteID(String new_id){
		this.site_id=new_id;
	}

	public List<String> getTxtFiles(File dir){
		List<String> results = new ArrayList<String>();
		try{walk(dir, results);}catch(Exception e){System.err.println(e);}
		return results;
	}

	public List<String> getTxtFiles(String dir){
		if(dir==null)
			return new ArrayList<String>();
		return this.getTxtFiles(new File(dir));
	}

	protected boolean handleDirectory(File directory, int depth, Collection results){
		String fn=new String();
		try{
			fn=FilenameUtils.separatorsToUnix(directory.getCanonicalPath());
		}catch(Exception e){System.err.println(e);}
		if(StringUtils.indexOfAny(fn, new String[]{"/core","/dist","/"+this.site_id})!=-1)
			results.add(fn);
		return true;
	}
}