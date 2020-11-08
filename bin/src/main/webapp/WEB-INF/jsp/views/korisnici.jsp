<%@include file="/WEB-INF/jsp/views/template/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
         

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
                        <div class="panel-heading">
                            Basic Form Elements
                        </div>
                        <div class="panel-body">
          
                            <div class="row">
                                <div class="col-lg-6">
                                    
                                    <form:form role="form" action="saveCustomer" modelAttribute="customer"  method="POST">
										<!-- need to associate this data with customer id -->
										<form:hidden path="id" />
										         
                                        
                                        <div class="form-group">
                                            <label>Naziv korisnika</label>
                                            <form:errors path="name" cssStyle="color: #ff0000;" />
                                            <form:input path="name" class="form-control" placeholder="Naziv korisnika" />
                                        </div>
                                        
                                         <div class="form-group"> 
                                            <label>eMail korisnika</label>
                                            <form:errors path="eMail" cssStyle="color: #ff0000;" />
                                            <form:input path="eMail" class="form-control" placeholder="eMail" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Broj telefona korisnika</label>
                                            <form:input type="tel" path="phone" class="form-control" placeholder="Broj telefona korisnika" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Adresa korisnika</label>
                                            <form:input path="addressa" class="form-control" placeholder="Adresa korisnika" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Grad</label>
                                            <form:input path="grad" class="form-control" placeholder="Grad" />
                                        </div>
                                        
                                        
                                        
                                        
                                   
                                        <div class="form-group">
                                            <label>Opis</label>
                                            <textarea class="form-control" rows="3"></textarea>
                                        </div>
                                        
                                        </div>
                                        
                                        <td><input type="submit" value="Save" class="btn btn-default" /></td>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                       
                                    </form:form>
                                        
                                </div>
                                
                                <!-- /.col-lg-6 (nested) -->
                            </div>
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
   <%@include file="/WEB-INF/jsp/views/template/footer.jsp" %>