<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




<div class="modal-header">

	<button type="button" class="close" data-dismiss="modal">&times;</button>
	<h4 class="modal-title">Update</h4>
</div>
<div class="modal-body" >

	<p>Forma za update korisnika</p>

	<form:form action="update" modelAttribute="theLicenca" method="GET">

		<!-- need to associate this data with customer id -->
		<form:hidden path="id" />
		<style>
					td {
						 padding: 10px 0
						}
						
						#container {width:100%; text-align:center;}
						
		</style>

		<table >
			<tbody>
				<!-- 		<tr>
																	<td><label>Tip licence</label></td>
																	<td>${theLicenca.tipLicence}</td>
																	<td><form:input path="tipLicence" /></td>
														</tr>	 -->
				<tr>
					<td><label>Tip Licence</label></td>
				</tr>

				<tr>

					<td>
						<div class="form-group">
							<form:select path="tipLicence">
								<label>Radio Buttons</label>
								<div class="radio">
									<label> <form:option type="radio" name="optionsRadios"
											id="optionsRadios1" value="Windows" />Windows
									</label>
								</div>
								<div class="radio">
									<label> <form:option type="radio" name="optionsRadios"
											id="optionsRadios2" value="Anti virus" />Anti virus
									</label>
								</div>
								<div class="radio">
									<label> <form:option type="radio" name="optionsRadios"
											id="optionsRadios3" value="Firewall/Router" />Firewall/Router
									</label>
								</div>
								<div class="radio">
									<label> <form:option type="radio" name="optionsRadios"
											id="optionsRadios3" value="Racunar PC/Server" />Racunar
										PC/Server
									</label>
								</div>
							</form:select>
						</div>
					</td>
				</tr>

				<tr>
					<td>
						<div class="col-xs-4">
							<label>instalirano</label>
							<form:input path="instalirano" type='text1' class="form-control"
								id='datepicker' />
						</div>
					</td>

					<td>
						<div class="col-xs-4">
							<label>Dat</label>
							<form:input path="datumIsteka" type='text1' class="form-control"
								id='datepicker' />
						</div>
					</td>


					<td>
						<div class="col-xs-4">
							<label>Instalirano</label>
							<form:input path="instalirano" type='text1' class="form-control"
								id='datepicker' />
						</div>
					</td>
				</tr>
				
				<tr>
					<div class="form-group row ">
						<td>
							<div class="col-xs-4">
								<label>Br. fakt</label>
								<form:input path="brojFakture" class="form-control"
									placeholder='Kat. broj'></form:input>
							</div>
						</td>
						<td>
							<div class="col-xs-4">
								<label></label>
								<form:input path="brojPredracuna" class="form-control"
									placeholder='Broj predracuna'></form:input>
							</div>
						</td>
						<td>
							<div class="col-xs-4">
								<label></label>
								<form:input type="number" path="kolicinaLicenci" class="form-control"
									placeholder='Kolicina' />
							</div>
							
						</td>
						
					</div>
					
					
				</tr>
				<tr>                 
					<td colspan="110" >
					<div class="form-group">
					<form:textarea text-align="center" placeholder='Opis' path="opis"  class="form-control" rows="3" cols="110" />                              
	                </div>  
					</td>
					
				</tr>
				


			</tbody>
		</table>

	
	



<div class="modal-footer">
	<input type="submit" value="Save" class="btn btn-default" />
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
</div>

</form:form>
</div>
<script type="text/javascript">
																		  $(document).ready(function() {  
																		
																		  $("[type$=text1]").datepicker(
																				  {
																					    format: 'dd/mm/yyyy'
																					   
																					}	  
																		  );
																		});
													    </script>



