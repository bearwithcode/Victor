            <div id="cocomo" class="body_divisions hidden">

            	<h3>Constructive Cost Model (COCOMO)</h3>
          		<ul class="nav nav-tabs" role="tablist">
            		<li role="presentation" class="active"><a href="#cocomo1" role="tab" data-toggle="tab">COCOMO I</a></li>
            		<li role="presentation"><a href="#cocomo2" role="tab" data-toggle="tab">COCOMO II</a></li>
          		</ul>

          		<div class="tab-content">
          			<div role="tabpanel" class="tab-pane fade in active" id="cocomo1">
          				<div class="container-fluid">
          					<br>
          					<form>
          						<fieldset><legend>COCOMO I:</legend>
	          						<div class="form-group">
		          						<label for="system_type_select" class="control-label">System Type:</label>
								        <select id="system_type_select" class="form-control">
								                <option value="1">Organic</option>
								                <option value="2">Semi-detached</option>
								                <option value="3">Embedded</option>
								        </select>
		          					</div>
		          					<div class="form-group">
		          						<label for="lines_of_code_cocomo1" class="control-label">Lines of Code:</label>
	                    				<input class="form-control" id="lines_of_code_cocomo1" type="text">
		          					</div>
		          				</fieldset>
	          					<fieldset><legend>Effort Estimation:</legend>
									<div class="form-group"> 
		          						<output id="cocomo1_output">Please enter the variables above to calculate the effort estimatation of this project.</output>
		          					</div>
		          				</fieldset>
          					</form>
          				</div>
					</div>

					<div role="tabpanel" class="tab-pane fade" id="cocomo2">
						<div class="container-fluid">
							<br>
							<form class="form-horizontal">
								<fieldset><legend>COCOMO II:</legend>
									<ul>
										<li>
				      					<fieldset><legend>Scale Factor Values:</legend>
				      						<div class="form-group"> 
					      						<label for="prec_val" class="col-sm-3 control-label">Precedentedness (PREC):</label>
					      						<div class="col-sm-9">
					      							<select id="prec_val" class="form-control">
						                              <option value="0">Very low</option>
						                              <option value="1">Low</option>
						                              <option value="2">Nominal</option>
						                              <option value="3">High</option>
						                              <option value="4">Very High</option>
						                              <option value="5">Extra High</option>
						                            </select>
					      						</div>
					      					</div>
					      					<div class="form-group"> 
					      						<label for="flex_val" class="col-sm-3 control-label">Development flexibility (FLEX):</label>
					      						<div class="col-sm-9">
					      							<select id="flex_val" class="form-control">
						                              <option value="0">Very low</option>
						                              <option value="1">Low</option>
						                              <option value="2">Nominal</option>
						                              <option value="3">High</option>
						                              <option value="4">Very High</option>
						                              <option value="5">Extra High</option>
						                            </select>
					      						</div>
					      					</div>
					      					<div class="form-group"> 
					      						<label for="resl_val" class="col-sm-3 control-label">Architecture/risk resolution (RESL):</label>
					      						<div class="col-sm-9">
					      							<select id="resl_val" class="form-control">
						                              <option value="0">Very low</option>
						                              <option value="1">Low</option>
						                              <option value="2">Nominal</option>
						                              <option value="3">High</option>
						                              <option value="4">Very High</option>
						                              <option value="5">Extra High</option>
						                            </select>
					      						</div>
					      					</div>
					      					<div class="form-group"> 
					      						<label for="team_val" class="col-sm-3 control-label">Team cohesion (TEAM):</label>
					      						<div class="col-sm-9">
					      							<select id="team_val" class="form-control">
						                              <option value="0">Very low</option>
						                              <option value="1">Low</option>
						                              <option value="2">Nominal</option>
						                              <option value="3">High</option>
						                              <option value="4">Very High</option>
						                              <option value="5">Extra High</option>
						                            </select>
					      						</div>
					      					</div>
					      					<div class="form-group"> 
					      						<label for="pmat_val" class="col-sm-3 control-label">Process maturity (PMAT):</label>
					      						<div class="col-sm-9">
					      							<select id="pmat_val" class="form-control">
						                              <option value="0">Very low</option>
						                              <option value="1">Low</option>
						                              <option value="2">Nominal</option>
						                              <option value="3">High</option>
						                              <option value="4">Very High</option>
						                              <option value="5">Extra High</option>
						                            </select>
					      						</div>
					      					</div>
				      					</fieldset>
				      					</li>
				      				</ul>
			      				</fieldset>
								<div class="form-group">
	          						<label for="lines_of_code_cocomo2" class="control-label">Lines of Code:</label>
                    				<input class="form-control" id="lines_of_code_cocomo2" type="text">
	          					</div>
	          					<fieldset><legend>Effort Estimation:</legend>
									<div class="form-group"> 
		          						<output id="cocomo2_output">Please enter the variables above to calculate the effort estimatation of this project.</output>
		          					</div>
		          				</fieldset>
							</form>
						</div>
					</div>

          		</div> <!-- End tab content -->
            </div>