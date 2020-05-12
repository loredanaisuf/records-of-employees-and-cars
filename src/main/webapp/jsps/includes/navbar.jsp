 <header class="bmd-layout-header" style="background-color: #660020;">
     <div class="navbar navbar-light bg-faded">
         <button class="navbar-toggler" type="button" data-toggle="drawer" data-target="#dw-s1">
             <span class="sr-only">Toggle drawer</span>
             <i class="material-icons" style="color: white;">menu</i>
         </button>
         <span class="navbar-brand mb-0 h1" style=" color: white; margin-left: 200px;">             </span>
         <span style=" color: white; margin-left: 500px;"></span>

         <form class="form-inline">
             <input class="form-control mr-sm-2" type="search" placeholder="Cauta" aria-label="Search">
         </form>

         <ul class="nav navbar-nav">
             <li class="nav-item">
                 <a href="${pageContext.request.contextPath}/logout "data-toggle="tooltip" title="Deconectare" style="color: white; margin-left: -50px; "><span class="material-icons">logout</span> </a>
             </li>
         </ul>
     </div>
 </header>

 <div id="dw-s1" class="bmd-layout-drawer bg-faded" style="color: #660020;">
<%--     <header>--%>
<%--         <a class="navbar-brand " style="background-color: #660020; color: white; text-align: center;">Acasa</a>--%>
<%--     </header>--%>
     <ul class="list-group">
         <a href="${pageContext.request.contextPath}/utilizatori" >
             <p   class="menu-list" style="background-color: #660020; color: white;">
                 <i class="material-icons" style="color:white; margin-right: 20px; size: 1px;">person</i>Utilizatori</p>
         </a>
         <a href="${pageContext.request.contextPath}/calendar">
             <p   class="menu-list" >
                 <i class="material-icons" style="color:#660020; margin-right: 20px; size: 1px;">today</i>Calendar</p>
         </a>
         <a href="${pageContext.request.contextPath}/masini">
             <p   class="menu-list">
                 <i class="material-icons" style="color:#660020; margin-right: 20px; size: 1px;">directions_car</i>Masini</p>
         </a>
         <a href="${pageContext.request.contextPath}/remorci">
             <p  class="menu-list" >
                 <i class="material-icons" style="color:#660020; margin-right: 20px; size: 1px;">local_shipping</i> Remorci</p>
         </a>
         <a href="${pageContext.request.contextPath}/utilizatori">
             <p  class="menu-list">
                 <i class="material-icons" style="color:#660020; margin-right: 20px; size: 1px;">location_on</i>  Vezi locatiile</p>
         </a>
     </ul>
 </div>