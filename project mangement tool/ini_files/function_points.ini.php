            <div id="function_points" class="body_divisions hidden">
              <h3>Function Points</h3>

              <div class="container-fluid">
              	<form class="form-horizontal">
              		<fieldset><legend>Complexity Multipliers</legend>
              		<ul>
              			<li>
              			<fieldset><legend>Data Functions:</legend>
	              			<div class="form-group"> 
	      						<label for="ilf_val" class="col-sm-3 control-label">Internal Logic Files (ILF):</label>
	      						<div class="col-sm-9">
	      							<select id="ilf_val" class="form-control fp_input">
		                              	<option value="0">Low complexity</option>
			                            <option value="1">Medium complexity</option>
			                            <option value="2">High complexity</option>   
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="eif_val" class="col-sm-3 control-label">External Interface Files (EIF):</label>
	      						<div class="col-sm-9">
	      							<select id="eif_val" class="form-control fp_input">
		                              	<option value="0">Low complexity</option>
			                            <option value="1">Medium complexity</option>
			                            <option value="2">High complexity</option>   
		                            </select>
	      						</div>
	      					</div>
	              		</fieldset>
	              		</li>
	              		<li>
	              		<fieldset><legend>Transaction Functions:</legend>
	              			<div class="form-group"> 
	      						<label for="ei_val" class="col-sm-3 control-label">External Inputs (EI):</label>
	      						<div class="col-sm-9">
	      							<select id="ei_val" class="form-control fp_input">
		                              	<option value="0">Low complexity</option>
			                            <option value="1">Medium complexity</option>
			                            <option value="2">High complexity</option>   
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="eo_val" class="col-sm-3 control-label">External Outputs (EO):</label>
	      						<div class="col-sm-9">
	      							<select id="eo_val" class="form-control fp_input">
		                              	<option value="0">Low complexity</option>
			                            <option value="1">Medium complexity</option>
			                            <option value="2">High complexity</option>   
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="eq_val" class="col-sm-3 control-label">External Queries (EQ):</label>
	      						<div class="col-sm-9">
	      							<select id="eq_val" class="form-control fp_input">
		                              	<option value="0">Low complexity</option>
			                            <option value="1">Medium complexity</option>
			                            <option value="2">High complexity</option>   
		                            </select>
	      						</div>
	      					</div>
	              		</fieldset>
	              		</li>
	              		<li>
	              		<fieldset><legend>Value Adjustment Factors:</legend>
	              			<div class="form-group"> 
	      						<label for="data_comm_val" class="col-sm-3 control-label">Data Communications:</label>
	      						<div class="col-sm-9">
	      							<select id="data_comm_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>  
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="dist_data_val" class="col-sm-3 control-label">Distributed Data Processing:</label>
	      						<div class="col-sm-9">
	      							<select id="dist_data_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>  
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="perform_val" class="col-sm-3 control-label">Performance:</label>
	      						<div class="col-sm-9">
	      							<select id="perform_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>    
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 
	      						<label for="heavy_use_val" class="col-sm-3 control-label">Heavily Used Configuration:</label>
	      						<div class="col-sm-9">
	      							<select id="heavy_use_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>  
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="trans_rate_val" class="col-sm-3 control-label">Transaction Rate:</label>
	      						<div class="col-sm-9">
	      							<select id="trans_rate_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>  
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="online_data_val" class="col-sm-3 control-label">Online Data Entry:</label>
	      						<div class="col-sm-9">
	      							<select id="online_data_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>    
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 
	      						<label for="end_user_val" class="col-sm-3 control-label">End User Efficiency:</label>
	      						<div class="col-sm-9">
	      							<select id="end_user_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>  
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="online_update_val" class="col-sm-3 control-label">Online Update:</label>
	      						<div class="col-sm-9">
	      							<select id="online_update_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>  
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="complex_proc_val" class="col-sm-3 control-label">Complex Processing:</label>
	      						<div class="col-sm-9">
	      							<select id="complex_proc_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>    
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 
	      						<label for="reuse_val" class="col-sm-3 control-label">Reusability:</label>
	      						<div class="col-sm-9">
	      							<select id="reuse_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>  
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="install_ease_val" class="col-sm-3 control-label">Installation Ease:</label>
	      						<div class="col-sm-9">
	      							<select id="install_ease_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>  
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="oper_ease_val" class="col-sm-3 control-label">Operational Ease:</label>
	      						<div class="col-sm-9">
	      							<select id="oper_ease_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>    
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="multiple_sites_val" class="col-sm-3 control-label">Multiple Sites:</label>
	      						<div class="col-sm-9">
	      							<select id="multiple_sites_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>  
		                            </select>
	      						</div>
	      					</div>
	      					<div class="form-group"> 	
	      						<label for="fac_change_val" class="col-sm-3 control-label">Facilitate Change:</label>
	      						<div class="col-sm-9">
	      							<select id="fac_change_val" class="form-control fp_input">
		                              	<option value="0">No Influence</option>
			                            <option value="1">Incidental</option>
			                            <option value="2">Moderate</option>
			                            <option value="3">Average</option>
			                            <option value="4">Significant</option>  
			                            <option value="5">Essential</option>    
		                            </select>
	      						</div>
	      					</div>
	              		</fieldset>
	              		</li>
	              	</ul>
              		</form>
              		<fieldset><legend>Effort Estimation:</legend>
						<div class="form-group"> 
      						<output id="function_points_output">Please enter the variables above to calculate the function points of this project.</output>
      					</div>
      				</fieldset>
              	</form>
              </div>
            </div>