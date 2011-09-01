<?php 
/*
 * [The BSD License, http://www.opensource.org/licenses/bsd-license.php]
 * Copyright (c) 2009-2011, Sven van der Meer <sven@vandermeer.de>
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
 */

/**
 * Abstract base class for an SKB Reader implementing the process for reader/builder prepare/execute
 *
 * @package    Classes.SKB
 * @author     Sven van der Meer <sven@vandermeer.de>
 * @copyright  2009-2011 Sven van der Meer
 * @license    http://www.opensource.org/licenses/bsd-license.php  BSD License
 * @version    v1.0.0 build 110901 (01-Sep-11) for PHP v5.3.0
 */
abstract class SKB_Reader{
	/**
	 * The builder class linked to the reader.
	 * @var SKB_Builder
	 */
	protected $builder=null;


	/**
	 * Boolean to be set true if initialisation is successfully finished, false by default.
	 * @var boolean
	 */
	protected $is_prepared=false;


	/**
	 * Not used
	 * @var boolean
	 */
	protected $obj_id=false;


	/**
	 * An array that can be used to process information within the reader.
	 * @var array
	 */
	protected $entry_list;


	/**
	 * An array that should maintain all information the reader did prepare/collect.
	 * @var array
	 */
	protected $entries;


	/**
	 * Class constructor (empty)
	 */
	public function __construct(){}


	/**
	 * Associate an intantiated builder with the reader.
	 * 
	 * The class constructor only initialises the local variable templates.
	 *
	 * @param SKB_Builder builder the builder instance
	 */
	public function set_builder(SKB_Builder $builder){
		$this->builder=$builder;
		$this->builder->set_header();
	}


	/**
	 * Prepare (reader only) and Execute (reader and builder).
	 * 
	 * This function will call prepare and execute on the reader. It is a shortcut to calling prepare first and 
	 * execute next on the reader.
	 *
	 * @param SKB_Request request the request object to paremeterise the function call
	 */
	public function prepare_and_execute(SKB_Request $request){
		$this->prepare($request);
		$this->execute($request);
	}


	/**
	 * Prepare the reader.
	 * 
	 * Prepare basically means to do everything needed prior invoking execute. Usually, this would
	 * mean initialise all data structures, possibly reading and processing data from external sources and
	 * other preparation tasks. This function will call prepare_loop before and set is_prepared to true before returning.
	 *
	 * @param SKB_Request request the request object to paremeterise the function call
	 */
	public function prepare(SKB_Request $request){
		if($request->is_activated()==true){
			$sematag=$request->get_sematag();
			$sematag_collections=$request->get_sematag_collections();

			$this->entry_list=array();
			$this->entries=array();

			$this->prepare_loop($request, $sematag, $sematag_collections);
			$this->is_prepared=true;
		}
	}


	/**
	 * Local Prepare function.
	 * 
	 * If you want your reader to do anything in the preparation stage, simply put all that code in this function.
	 * It will be automatically called by the base object.
	 *
	 * @param SKB_Request request the request object to paremeterise the function call
	 * @param string sematag semantic tag to be used to read from external data sources
	 * @param string sematag_collections semantic tag to be used to read collections from external data sources
	 */
	abstract public function prepare_loop(SKB_Request $request, $sematag, $sematag_collections);


	/**
	 * Execute the reader and the builder.
	 * 
	 * Execute all remaining functionality on the reader first and then call the builder's execute function to 
	 * finish the job. This is only done if is_prepared is true and if a builder was provided (set_builder).
	 *
	 * @param SKB_Request request the request object to paremeterise the function call
	 */
	public function execute(SKB_Request $request){
		if($this->is_prepared==false)
			return -1;
		if($this->builder==null)
			return -1;
	
		$this->execute_loop($request);
		$this->builder->execute($request, new Util_ArBase($this->entries));
	}


	/**
	 * Local Execute function.
	 * 
	 * If you want your reader to do anything in the execution stage, simply put all that code in this function.
	 * It will be automatically called by the base object.
	 *
	 * @param SKB_Request request the request object to paremeterise the function call
	 */
	abstract public function execute_loop(SKB_Request $request);


	/**
	 * Return the current array of entries as Util_ArBase.
	 */
	public function get_entries(){
		if($this->is_prepared==false)
			return -1;
		return new Util_ArBase($this->entries);
	}
}
?>