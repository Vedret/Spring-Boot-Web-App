<!-- /#wrapper -->

    <!-- jQuery 
    <script src="../vendor/jquery/jquery.min.js"></script>-->
    <script src="<c:url value="/vendor/jquery/jquery.min.js" />" ></script>

    <!-- Bootstrap Core JavaScript 
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>-->
    <script src="<c:url value="/vendor/bootstrap/js/bootstrap.min.js" />" ></script>

    <!-- Metis Menu Plugin JavaScript 
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>-->
    <script src="<c:url value="/vendor/metisMenu/metisMenu.min.js" />" ></script>

    <!-- Morris Charts JavaScript 
    <script src="../vendor/raphael/raphael.min.js"></script>
    <script src="../vendor/morrisjs/morris.min.js"></script>
    <script src="../data/morris-data.js"></script>
    
    <script src="<c:url value="/vendor/raphael/raphael.min.js" />"></script>
    <script src="<c:url value="/vendor/morrisjs/morris.min.js" />"></script>
    <script src="<c:url value="/data/morris-data.js" />"></script>-->
   
    
    <!-- DataTables JavaScript -->
    <script src="<c:url value="/vendor/datatables/js/jquery.dataTables.min.js"/>"> </script>
    <script src="<c:url value="/vendor/datatables-plugins/dataTables.bootstrap.min.js"/>"></script>
    <script src="<c:url value="/vendor/datatables-responsive/dataTables.responsive.js"/>"></script>
    

    
    <script src="../dist/js/sb-admin-2.js"></script>
    <!-- Custom Theme JavaScript
    <script src="<c:url value="/dist/js/sb-admin-2.js"/>" > </script> -->
      <script src='//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/js/bootstrap-datepicker.min.js' type='text/javascript'></script>
  <script src='//cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/1.8/js/bootstrap-switch.min.js' type='text/javascript'></script>
    
      <script type="text/javascript"  >
					  $(document).ready(function() {  
					
					  $("[type$=text1]").datepicker(
							  {
								    format: 'dd/mm/yyyy'
								   
								}	  
					  );
					});
    </script>
    
    
     <!-- Custom Theme JavaScript PAGINATION -->
    <script>
		    $(document).ready(function() {
		        $('#dataTables-example').DataTable({
		            responsive: true,
		            sInfo: true
		        });
		    });
		    
		   
	</script>
		    
   
   

</body>

</html>
    
