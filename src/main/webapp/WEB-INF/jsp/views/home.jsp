<%@include file="/WEB-INF/jsp/views/template/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
         


        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Korisnici</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Tabela korisnika licenci , evidencija racunara
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                       <th>id</th>
                                        <th>Korisnik</th>
                                        <th>eMail</th>
                                        <th>Tip</th>
                                        <th>Kat.br</th>
                                        <th>Kolicina</th>                                       
                                        <th>Isporuceno</th>
                                        <th>Traje do</th> 
                                        <th>Akcija</th>         
                                    </tr>
                                </thead>
                                <tbody>
                               
                                <c:forEach var="ph" items="${customer}">
					        	<c:forEach var="ph1" items="${ph.licence}" varStatus="vs">
					        	
					        	<!-- construct an "pdf" link with customer id -->
											<c:url var="pdfLink" value="/details/pdf">
												<c:param name="licenceId" value="${ph1.id}" />
											</c:url>					
						
								 <!-- construct an "delete" link with customer id -->
											<c:url var="deleteLink" value="/delete">
												<c:param name="licenceId" value="${ph1.id}" />
											</c:url>	
											
								 <!-- construct an "update link" link with customer id -->
												 <c:url var="updateLink" value="/showFormUpdate">
													 <c:param name="licenceId" value="${ph1.id}" />
												</c:url>
					        	
					        	
					        	
						        	<tr class="odd gradeX">
							        	<td width ="10px" class="center">${ph1.id }</td>
							        	<td width ="25%">${ph.name}</td>
							        	<td width ="15%">${ph.eMail}</td>
							        	<td>${ph1.tipLicence}</td>
							        	<td>${ph1.katBroj}</td>
							        	<td >${ph1.kolicinaLicenci}</td>
							        	<td>${ph1.isporuceno}</td>
							        	<td>${ph1.istekLicence}</td>
							        	<td width ="10%">
							        	
							        	
							        	
							        	
								        	<!-- display the update link -->
											
											<a href="${updateLink}"   data-toggle="modal" data-target="#myModal${vs.index}">Update</a>
											<!-- Modal -->
											  
											  <!-- need to associate this data with customer id -->
											 
											  <div class="modal fade" id="myModal${vs.index}" tabindex="-1" role="dialog">
											    <div class="modal-dialog modal-lg">
											    
											      <!-- Modal content-->
											      <div class="modal-content">
											      </div>
											      </div>
											      </div>
											      	
											  
											
											
											
												|
											<a href="${deleteLink}" onclick="if (!(confirm('Da li ste sigurni da zelite obrisati ovo?'))) return false">Delete</a>
												 |	 
											<a href="${pdfLink}" target="_blank">PDF</a>  
							        	</td>
						        	</tr>     
								</c:forEach>
					            </c:forEach>
                              
                                </tbody>
                              
                            </table>
                            <!-- /.table-responsive -->
                            <div class="well">
                                <h4>DataTables Usage Information</h4>
                                <p>DataTables is a very flexible, advanced tables plugin for jQuery. In SB Admin, we are using a specialized version of DataTables built for Bootstrap 3. We have also customized the table headings to use Font Awesome icons in place of images. For complete documentation on DataTables, visit their website at <a target="_blank" href="https://datatables.net/">https://datatables.net/</a>.</p>
                                <a class="btn btn-default btn-lg btn-block" target="_blank" href="https://datatables.net/">View DataTables Documentation</a>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <!-- /.row -->
            
            <!-- /.row -->
            
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   <%@include file="/WEB-INF/jsp/views/template/footer.jsp" %>