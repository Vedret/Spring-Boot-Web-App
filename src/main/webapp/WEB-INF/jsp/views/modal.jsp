<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal-header">

	<button type="button" class="close" data-dismiss="modal">&times;</button>
	<h4 class="modal-title">Modal Header</h4>
</div>
<div class="modal-body">

	<p>Some text Jebace matere djelim na faktore</p>

	<form:form action="update" modelAttribute="theLicenca"
		method="GET">

		<!-- need to associate this data with customer id -->
		<form:hidden path="id" />

		<table>
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
							<label>Isporuceno</label>
							<form:input path="isporuceno" type='text' class="form-control"
								id='datepicker' />
						</div>
					</td>

					<td>
						<div class="col-xs-4">
							<label>Traje do</label>
							<form:input path="istekLicence" type='text' class="form-control"
								id='datepicker' />
						</div>
					</td>


					<td>
						<div class="col-xs-4">
							<label>Istice</label>
							<form:input path="isporuceno" type='text' class="form-control"
								id='datepicker' />
						</div>
					</td>
				</tr>
				<p>
				<p>
				<p>
				<tr>
					<div class="form-group row ">
						<td>
							<div class="col-xs-4">
								<label>Broj</label>
								<form:input path="katBroj" class="form-control"
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
								<form:input path="kolicinaLicenci" class="form-control"
									placeholder='Kolicina' />
							</div>
						</td>

					</div>
				</tr>
				<tr>
					<td>
						<div class="form-group">
                                                              
                                <form:textarea path="opis"  class="form-control" rows="3" />                              
                        </div>
					</td>
				</tr>
				


			</tbody>
		</table>

	<td><input type="submit" value="Save" class="btn btn-default" /></td>
	</form:form>



</div>
<div class="modal-footer">
	
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
</div>

<script type="text/javascript">
																		  $(document).ready(function() {  
																		
																		  $('#datepicker').datepicker(
																				  {
																					    format: 'dd/mm/yyyy'
																					   
																					}	  
																		  );
																		});
													    </script>



