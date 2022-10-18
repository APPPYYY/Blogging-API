$(function() {
	switch (menu) {
	case 'Home Page':
		$('#home').addClass('active');
		break;
	case 'About Us Page':
		$('#about').addClass('active');
		break;
	case 'Product Page':
		$('#products').addClass('active');
		break;
	}

	var $table = $('#userDataTable');

	if ($table.length) {

		var jsonUrl = '';

		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/features/'
					+ window.categoryId + '/products';

		}

		$table
				.DataTable({
					lengthMenu : [
							[ 5, 10, 15, -1 ],
							[ '5 records', '10 records', '15 records',
									'All records' ] ],
					pageLength : 4,

					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/abc/images/' + data
											+ '.jpg" class="dataTableImg"/>';
								}
							},
							{
								bSortable : false,
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377;' + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red"><b>Out Of Stock</b></span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								mRender : function(data, type, row) {
									var str = ''
									str += '<a href="'
											+ contextRoot
											+ '/view/'
											+ data
											+ '/catagory" class="btn btn-primary"><svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd"><path d="M12.01 20c-5.065 0-9.586-4.211-12.01-8.424 2.418-4.103 6.943-7.576 12.01-7.576 5.135 0 9.635 3.453 11.999 7.564-2.241 4.43-6.726 8.436-11.999 8.436zm-10.842-8.416c.843 1.331 5.018 7.416 10.842 7.416 6.305 0 10.112-6.103 10.851-7.405-.772-1.198-4.606-6.595-10.851-6.595-6.116 0-10.025 5.355-10.842 6.584zm10.832-4.584c2.76 0 5 2.24 5 5s-2.24 5-5 5-5-2.24-5-5 2.24-5 5-5zm0 1c2.208 0 4 1.792 4 4s-1.792 4-4 4-4-1.792-4-4 1.792-4 4-4z"/></svg></a>';
									str += '<a href="'
											+ contextRoot
											+ '/cart/'
											+ data
											+ '/catagory" class="btn btn-warning"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M10 19.5c0 .829-.672 1.5-1.5 1.5s-1.5-.671-1.5-1.5c0-.828.672-1.5 1.5-1.5s1.5.672 1.5 1.5zm3.5-1.5c-.828 0-1.5.671-1.5 1.5s.672 1.5 1.5 1.5 1.5-.671 1.5-1.5c0-.828-.672-1.5-1.5-1.5zm1.336-5l1.977-7h-16.813l2.938 7h11.898zm4.969-10l-3.432 12h-12.597l.839 2h13.239l3.474-12h1.929l.743-2h-4.195z"/></svg></a>';
									return str;
								}
							} ]

				});
	}

});