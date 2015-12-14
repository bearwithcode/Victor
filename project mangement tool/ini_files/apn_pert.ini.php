            <div id="activity_precedence_network" class="body_divisions hidden">
            	<h3>Activity Precedence Network &amp; Project Evaluation and Review Technique (PERT) Analysis</h3>
            	<ul>
            		<li>
            			<fieldset><legend>Activity Precedence Network</legend>
		             		<div id="apn_div" style="border: solid 1px gray; width:100%; height:400px"></div>
		             	</fieldset>
		             	<br>
            		</li>
            		<li>
            			<fieldset><legend>PERT Analysis</legend>
		             		<div class="form-group">
          						<label for="project_target_days" class="control-label">Project Target (Number of Days):</label>
                				<input class="form-control" id="project_target_days" type="text">
          					</div>
		             	</fieldset>
		             	<fieldset><legend>Likelihood of Meeting Project Target:</legend>
							<div class="form-group"> 
		  						<output id="pert_output">Please enter the project target to calculate the chance of this project meeting that target.</output>
		  					</div>
		  				</fieldset>
		  				<button type="button" class="btn btn-primary" id="view_z_graph_button">View Z-Value Graph</button>
		  				<br>
		  				<br>
		  				<img src="images/z_val_graph.png" id="z_graph_img" class="img-responsive" style="display: none;" alt="Z-Value Graph">
            		</li>
            	</ul>

            </div>