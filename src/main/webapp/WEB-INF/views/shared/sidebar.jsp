<div class="col-md-12 px-sm-2 px-0 bg-light  ">
	<div
		class=" d-flex flex-column align-items-center align-items-sm-start px-3 pt-2  min-vh-100 text-dark bg-light fst-italic text-uppercase"
		>
		<a href="/"
			class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
			<span class="fs-5 d-none d-sm-inline text-dark " style="color: black"><b>Products
					List</b></span>
		</a>
		<ul
			class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
			id="menu">
			<c:forEach var="category" items="${category}">
				<li class="nav-item"><a href="javascript:void(0)"
					class="nav-link align-middle px-0"> <i class="fs-4 bi-house"></i>
						<span class="ms-1 d-none d-sm-inline text-white" style="color: black"><b>${category.cid}
								- ${category.cname}</b></span>
				</a></li>
			</c:forEach>
		</ul>
		<hr>

	</div>
</div>