$(document).ready(function(){
	var masanpham = 0;
	
	$("#cot1").click(function(){
		var chuoi = $("#cot1").attr("data-text");
		alert(chuoi);
	});
	
	$("#btnDangNhap").click(function(){
		var ten = $("#email").val();
		var password = $("#matkhau").val();
		
		$.ajax({
			url:"/minishop/api/KiemTraDangNhap",
		    type:"GET",
		    data:{
		    	email:ten,
		    	matkhau:password
		    },
			success: function(value){
				if(value == "true"){
					duongDanHienTai = window.location.href;
					duongDan = duongDanHienTai.replace("dangnhap/","");
					window.location = duongDan;
					
				}else{
					$("#ketqua").text("dang nhap that bai !")
				}
				
			}
		})
		
		
	});
	
	$("#dangnhap").click(function(){
		$(this).addClass("actived");
		$("#dangky").removeClass("actived");
		$(".container-login-form").show();
		$(".container-signup-form").css("display","none");
	});
	
	$("#dangky").click(function(){
		$(this).addClass("actived");
		$("#dangnhap").removeClass("actived");
		$(".container-login-form").hide();
		$(".container-signup-form").show();
	});
	
	$(".btn-giohang").click(function(){
		var machitiet = $(this).attr("data-machitiet");
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var tenmau = $(this).closest("tr").find(".mau").text();
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var tensize = $(this).closest("tr").find(".size").text();
		var soluong = $(this).closest("tr").find(".soluong").text();
		var tensp = $("#tensp").text();
		var masp = $("#tensp").attr("data-masp");
		var giatien = $("#giatien").attr("data-value");
		
		
		$.ajax({
			url:"/minishop/api/ThemGioHang",
		    type:"GET",
		    data:{
		    	masp:masp,
		    	masize:masize,
		    	mamau:mamau,
		    	tensp: tensp,
		    	giatien:giatien,
		    	tenmau:tenmau,
		    	tensize:tensize,
		    	soluong:soluong,
		    	machitiet:machitiet
		    	
		    },
			success: function(value){
				$("#giohang").find("div").addClass("circle-giohang");
				$("#giohang").find("div").html("<span>" + value + "</span>") ;
			}
		})    
//		}).done(function(){
//			$.ajax({
//				url:"/minishop/api/LaySoLuongGioHang",
//			    type:"GET",
//				success: function(value){
//					$("#giohang").find("div").addClass("circle-giohang");
//					$("#giohang").find("div").html("<span>" + value + "</span>") ;
//				}
//			})
//		});
	});
	
	
	GanTongTienGioHang();
	
	function GanTongTienGioHang(isEventChange){
		var tongtiensp = 0;	
		$(".giatien").each(function(){
			var giatien = $(this).text();
			var soluong = $(this).closest("tr").find(".soluong-giohang").val();
			
			var tongtien = parseInt(giatien) * soluong;
			var format = parseFloat(tongtien).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.")
		
			if(!isEventChange){
				$(this).html(format);
			}
			
			tongtiensp = tongtiensp +  tongtien
			var formatTongtien = tongtiensp.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString()
			$("#tongtien").html(formatTongtien+"")
			
		})
	}
	
	$(".xoa-giohang").click(function(){
		var self = $(this);
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var masp = $(this).closest("tr").find(".tensp").attr("data-masp");
		
		$.ajax({
			url:"/minishop/api/XoaGioHang",
		    type:"GET",
		    data:{
		    	masp:masp,
		    	masize:masize,
		    	mamau:mamau,
		    	
		    },
			success: function(value){
				self.closest("tr").remove();
				GanTongTienGioHang(true);
			}
		})   
	})
	
	$(".soluong-giohang").change(function(){
		var soluong = $(this).val();
		var giatien = $(this).closest("tr").find(".giatien").attr("data-value");
		
		var tongtien = soluong * parseInt(giatien);
		var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString()
		$(this).closest("tr").find(".giatien").html(format);
		GanTongTienGioHang(true);
		
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var masp = $(this).closest("tr").find(".tensp").attr("data-masp");
		
		$.ajax({
			url:"/minishop/api/CapNhatGioHang",
		    type:"GET",
		    data:{
		    	masp:masp,
		    	masize:masize,
		    	mamau:mamau,
		    	soluong:soluong
		    	
		    },
			success: function(value){
				
			}
		})    
	})
	
//	$(".soluong-giohang").blur(function(){
//		var soluong = $(this).val();
//		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
//		var masize = $(this).closest("tr").find(".size").attr("data-masize");
//		var masp = $(this).closest("tr").find(".tensp").attr("data-masp");
//		
//		$.ajax({
//			url:"/minishop/api/CapNhatGioHang",
//		    type:"GET",
//		    data:{
//		    	masp:masp,
//		    	masize:masize,
//		    	mamau:mamau,
//		    	soluong:soluong
//		    	
//		    },
//			success: function(value){
//				
//			}
//		})    
//	})
	
	$("body").on("click",".paging-item",function(){
		$(".paging-item").removeClass("active");
		$(this).addClass("active");
		var sotrang = $(this).text();
		var spbatdau = (sotrang - 1) * 5;
		
		$.ajax({
			url:"/minishop/api/LaySanPhamLimit",
		    type:"GET",
		    data:{
		    	spbatdau:spbatdau,
		    	
		    },
			success: function(value){
				var tbodysanpham = $("#table-sanpham").find("tbody");
				tbodysanpham.empty();
				tbodysanpham.append(value);
			}
		})
	})
	
	$("#checkall").change(function(){
		if(this.checked){
			$("#table-sanpham input").each(function(){
				$(this).attr("checked",true);
			})
		}else{
			$("#table-sanpham input").each(function(){
				$(this).attr("checked",false);
			})
		}
	})
	
	$("#xoa-sanpham").click(function(){
		$("#table-sanpham > tbody input:checked").each(function(){
			var masanpham = $(this).val();
			var This = $(this);
			This.closest("tr").remove();
			$.ajax({
				url:"/minishop/api/XoaSanPham",
			    type:"GET",
			    data:{
			    	masp:masanpham,
			    	
			    },
				success: function(value){
					This.closest("tr").remove();
				}
			})
		})
	})
	
	var files = [];
	var tenhinh = "";
	$("#hinhanh").change(function(event){
		files = event.target.files;
		tenhinh = files[0].name;
		forms = new FormData();
		forms.append("file",files[0]);
		
		$.ajax({
			url:"/minishop/api/UploadFile",
		    type:"POST",
		    data:forms,
		    contentType:false,
		    processData:false,
		    enctype: "multipart/form-data",
			success: function(value){
				
			}
		})
		
	})
	
	$("body").on("click",".btn-chitiet",function(){
		$(this).remove();
		var chitietclone = $("#chitietsanpham").clone().removeAttr("id");
		$("#containerchitietsanpham").append(chitietclone);
	})
	
	$("#btnThemSanPham").click(function(event){
		event.preventDefault();
		var formdata = $("#form-sanpham").serializeArray();
		json = {};
		arraychitiet = [];
		
		 $.each(formdata, function(i, field){
			 json[field.name]   = field.value;   		 
		 });
		
		 $("#containerchitietsanpham >.chitietsanpham").each(function(){
			 objectChitiet = {};
			 mausanpham = $(this).find('select[name="mausanpham"]').val();
			 sizesanpham = $(this).find('select[name="sizesanpham"]').val()
			 soluong = $(this).find('input[name="soluong"]').val();
			 
			 
			 objectChitiet["mausanpham"] = mausanpham;
			 objectChitiet["sizesanpham"] = sizesanpham;
			 objectChitiet["soluong"] = soluong;
			 
			 arraychitiet.push(objectChitiet);
		 })
		 
		 json["chitietsanpham"] = arraychitiet;
		 json["hinhsanpham"] = tenhinh;

		 
		 $.ajax({
				url:"/minishop/api/themsanpham",
			    type:"POST",
			    data:{
			    	dataJson: JSON.stringify(json)
			    },
				success: function(value){
					
				}
			})
		 
	})
	
	$("#btnCapNhatSanPham").click(function(event){
		event.preventDefault();
		var formdata = $("#form-sanpham").serializeArray();
		json = {};
		arraychitiet = [];
		
		 $.each(formdata, function(i, field){
			 json[field.name]   = field.value;   		 
		 });
		
		 $("#containerchitietsanpham >.chitietsanpham").each(function(){
			 objectChitiet = {};
			 mausanpham = $(this).find('select[name="mausanpham"]').val();
			 sizesanpham = $(this).find('select[name="sizesanpham"]').val()
			 soluong = $(this).find('input[name="soluong"]').val();
			 
			 
			 objectChitiet["mausanpham"] = mausanpham;
			 objectChitiet["sizesanpham"] = sizesanpham;
			 objectChitiet["soluong"] = soluong;
			 
			 arraychitiet.push(objectChitiet);
		 })
		 
		 json["masanpham"] = masanpham;
		 json["chitietsanpham"] = arraychitiet;
		 json["hinhsanpham"] = tenhinh;
		 
		 
		 $.ajax({
				url:"/minishop/api/capnhatsanpham",
			    type:"POST",
			    data:{
			    	dataJson: JSON.stringify(json)
			    },
				success: function(value){
					
				}
			})
	})
	
	$("body").on("click",".capnhatsanpham",function(){
		masanpham = $(this).attr("data-id");

		$("#btnCapNhatSanPham").removeClass("hidden");
		$("#btnThoat").removeClass("hidden");
		$("#btnThemSanPham").addClass("hidden");
		
		$.ajax({
			url:"/minishop/api/LayDanhSachSanPhamTheoMa",
		    type:"POST",
		    data:{
		    	masanpham: masanpham
		    },
			success: function(value){
				
				$("#tensanpham").val(value.tensanpham);
				$("#giatien").val(value.giatien);
				$("#mota").val(value.mota);
				if(value.gianhcho === "nam"){
					$("#rd-nam").prop("checked",true);
				}else{
					$("#rd-nu").prop("checked",true);
				}
				
				$("#danhmucsanpham").val(value.danhmucsanpham.madanhmuc);
				
				$("#containerchitietsanpham").html("");
				
				var countchitiet = value.chitietsanpham.length;
				for(i=0; i<countchitiet;i++){
					var chitietclone = $("#chitietsanpham").clone().removeAttr("id");
					
					if(i < countchitiet - 1){
						chitietclone.find(".btn-chitiet").remove();
					}
					
					chitietclone.find("#mausanpham").val(value.chitietsanpham[i].mausanpham.mamau);
					chitietclone.find("#sizesanpham").val(value.chitietsanpham[i].sizesanpham.masize);
					chitietclone.find("#soluong").val(value.chitietsanpham[i].soluong);
					$("#containerchitietsanpham").append(chitietclone);
				}
				
				
			}
		})
	})
	
})