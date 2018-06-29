<%@include file="/WEB-INF/jsp/views/template/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Forms</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Basic Form Elements</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
						
							 
							 
							 <!-- need to associate this data with customer id -->
							 
							 	
							
							<form:form id="upload-file-form"   role="form" action="saveLicence" modelAttribute="licence"  method="POST" enctype="multipart/form-data" >
							<form:hidden path="id" />
							
							<div class="form-group ">
							
								<ul class="errorMessages"></ul>
								<label for="disabledSelect">Korisnik</label> 
								<select required name="customerid" id="disabledSelect" class="form-control">
									<option value="">Izaberite korisnika</option>
									 
									<c:forEach items="${customer}" var="databaseValue">
										
										<option   value="${databaseValue.id}"   >
										
										
	                              ${databaseValue.id} ${databaseValue.name}
	                             
	                              
	                            </option>
	                         
	                          
	                          
										</c:forEach>
										
									</select>						
							</div>
							
							
					 		
							
							<div class="form-group">
								 <form:select path="tipLicence" >
                                            <label>Radio Buttons</label>
                                            <div class="radio">
                                                <label>                                          	
                                                    <form:option type="radio" name="optionsRadios" id="optionsRadios1" value="Windows" />Windows
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <form:option   type="radio" name="optionsRadios" id="optionsRadios2" value="Anti virus"/>Anti virus
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <form:option  type="radio" name="optionsRadios" id="optionsRadios3" value="Firewall/Router"/>Firewall/Router
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <form:option  type="radio" name="optionsRadios" id="optionsRadios3" value="Racunar PC/Server"/>Racunar PC/Server
                                                </label>
                                            </div>
                                   </form:select>         
                                         
                            </div> 
								
							

								
							      <div class="form-group row ">
							      
							        <div class="col-xs-4">
							        	<label>Datum</label>	
							            <form:input path="datumPrijave"  type='text1' class="form-control" id='datepicker' />
							        </div>
							            
							        <div class="col-xs-4">
							        	<label>Datum Isteka</label>	
							            <form:input path="datumIsteka"  type='text1' class="form-control" id='datepicker' />
							        </div>
							            
							        <div class="col-xs-4">
							        	<label>Instalirano</label>	
							            <form:input path="instalirano"  type='text1' class="form-control" id='datepicker' />
							        </div>
							        
							         <div class="col-xs-4">
							        	<label>Fakturisano</label>	
							            <form:input path="fakturisano"  type='text1' class="form-control" id='datepicker' />
							        </div>
							     
													        
								<!--<div class="col-xs-4">
								<form:input path="datumIsteka" class="form-control" type="datepicker" placeholder='Do' ></form:input>
								</div>
								
								<div class="col-xs-4">
								<form:input  path="instalirano"  class="form-control" type="datepicker" placeholder='instalirano' /> 
								</div>-->
							
							</div>
							
							
							
							<div class="form-group row ">
							
								<div class="col-xs-4">
								<label>Br. fakture</label>	
								<form:input path="brojFakture"  class="form-control" placeholder='Broj fakture'  ></form:input>
								</div>
								
								<div class="col-xs-4">
								<label>Br. predrac.</label>	
								<form:input path="brojPredracuna"   class="form-control" placeholder='Broj predracuna'  ></form:input>
								</div>
								
								<div class="col-xs-4">
								<label>Br. licenci</label>	
								<form:input  path="kolicinaLicenci" class="form-control" placeholder='Broj Licenci'/> 
								</div>
							
							</div>
							
							<div class="form-group">
                                <label>Opis</label>                               
                                <form:textarea path="opis"  class="form-control" rows="3" />                              
                            </div>
                            
                          
					
					    <p style="color:red;">${message}</p>
					
							<div>
					        <label class="control-label" for="productImage">Upload file</label>
					        <form:input id="productImage"  path="productImage" type="file"  />
					       </div>
										
					<td><input type="submit" value="Save" class="btn btn-default" /></td>
                    <button type="reset" class="btn btn-default">Reset Button</button>	
                  	
				</form:form>
				
				<!-- /.row (nested) -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
</div>
<!-- /#page-wrapper -->

</div>
</div>
</div>
</div>
<%@include file="/WEB-INF/jsp/views/template/footer.jsp"%>