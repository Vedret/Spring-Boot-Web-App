<%@include file="/WEB-INF/jsp/views/template/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
         


        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Korisnici licenci</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Tabela korisnika licenci , evidencija 
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
                                        <th>Broj fakture</th>
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
												
												 <c:url var="downloadDoc" value="/downloadDoc">
													 <c:param name="licenceId" value="${ph1.id}" />
												</c:url>
					        	
					        	
					        	
						        	<tr class="odd gradeX">
							        	<td width ="10px" class="center">${ph1.id }</td>
							        	<td width ="25%">${ph.name}</td>
							        	<td width ="15%">${ph.eMail}</td>
							        	<td>${ph1.tipLicence}</td>
							        	<td>${ph1.brojFakture}</td>
							        	<td >${ph1.kolicinaLicenci}</td>							        	
							        	<td><fmt:formatDate value="${ph1.instalirano}" pattern="dd.MM.yyyy" /> </td>
							        	<td><fmt:formatDate value="${ph1.datumIsteka}" pattern="dd.MM.yyyy" /></td>
							        	<td width ="15%">
							        	
							        	
							        	
							        	
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
												|	
											<a href="${downloadDoc}" target="_blank">Doc</a>	
										 <!--	<a href="<spring:url value="/resources/documents/2"/>">download</a>	-->
							        	</td>
						        	</tr>     
								</c:forEach>
					            </c:forEach>
                              
                                </tbody>
                              
                            </table>
                            <!-- /.table-responsive -->
                            <div class="well">
                                <h4>Tabelarni prikaz korisnika licenci</h4>
                                <p>Tabela pokazuje sve korisnike licenci , datume izdavanja i kolicine. U slucaju isteka licence program ce automatski eMailom da obavjesti administratora o vrsti licence i nazivu korisnika . </p>
                                <!-- <a class="btn btn-default btn-lg btn-block" target="_blank" href="https://datatables.net/">View DataTables Documentation</a>  -->
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