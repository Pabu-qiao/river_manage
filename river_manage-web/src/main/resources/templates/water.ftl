<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="initial-scale=1.0, user-scalable=no, width=device-width">
		<title>炜麒科技智慧河长</title>
		<link rel="stylesheet"
			href="http://cache.amap.com/lbs/static/main1119.css" />
		<script type="text/javascript"
			src="http://webapi.amap.com/maps?v=1.4.6&key=35a00c9542d77d94b04de1fc6ae98e69"></script>
		<script type="text/javascript"
			src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-treeview.min.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/bootstrap-treeview.js"></script>
		
		<style>
			#container {
				left: 20%;
				width: 80%;
			}
			#mapLayer{
				display:none;
			}
			#mapLayer.actived{
				display:inline-block;
			}
		</style>
	</head>
	
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-2">
					<div id="tree" class="treeview"></div>
				</div>
				<div id="container"></div>
				<div id='layer' class="col-lg-2 col-lg-offset-10">
					<span id='switch' class="glyphicon glyphicon-menu-hamburger" aria-hidden="true" style="position: absolute; right: 40px; top: 20px;font-size:30px;"></span>
				  	<ul id='mapLayer' class='' style="list-style-type:none;position:absolute;right:40px;top:20px;">
						<li><img src='img/info.png'/><label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox1" value="option1">感叹号</label></li>
						<li><img src='img/photo.png'/><label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox2" value="option2">照相机</label></li>
						<li><img src='img/city.png'/><label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox3" value="option3">没写</label></li>
						<li><img src='img/city.png'/><label class="checkbox-inline"><input type="checkbox" id="inlineCheckbox4" value="option4">待添加</label></li>
					</ul>
				</div>
			</div>
		</div>
	
		<script type="text/javascript">
			$(function() {
				var tree = [{text : '中华人民共和国',nodeCode : 0,nodes : [],}];
				$('#tree').treeview({
					data : tree,
				});
				//行政区划树展开
				$('#tree').on("nodeExpanded", function(event, data) {
					addNode(data.nodeId);
				});
				//行政区划树折叠
				$('#tree').on("nodeCollapsed", function(event, data) {
					$("#tree").data('treeview').clearNode(data.nodeId);
				});
				//选中行政区划
				$('#tree').on("nodeSelected",function(event, data){
					search(String($('#tree').data('treeview').getNode(data.nodeId).nodeCode).substr(0, 6));
				});
	
				//控图层选项卡显示与隐藏
				$('#layer').on('mouseover', function() {
					
					$('#switch').hide();
					$('#mapLayer').addClass('actived');
				});
				$('#layer').on('mouseout', function() {
					$('#mapLayer').removeClass('actived');
					$('#switch').show();
				});
				
	
				//创建信息marker集合
				var markers=[];
				markers.push(createMarker(map,[ 116.405467, 39.907761 ],"img/info.png",'marker1','0'));
				markers.push(createMarker(map,[ 114.405467, 36.907761 ],"img/info.png",'marker2','110100000000'));
				markers.push(createMarker(map,[ 109.405467, 31.707761 ],"img/info.png",'shamingzi','510000000000'));
				
				
				//定义复选框选中事件:开关河道部件
				$('#inlineCheckbox1').on('click',function(){
					if(this.checked){
						markers.forEach(function(e){
							e.show();
						});
					}else{
						markers.forEach(function(e){
							e.hide();
						});
					}
				});
				//创建信息marker点击事件：显示详细信息列表
				markers.forEach(function(e){
					//河道部件默认隐藏
					e.hide();
					e.on('click', function() {
						$('#infoModal').remove();
						$('body').append('<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"><div class="modal-dialog" role="document"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button><h4 class="modal-title" id="myModalLabel">详细信息</h4></div><div class="modal-body"><table id="infoTable" class="table table-striped" ><thead></thead><tbody></tbody></table></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></div></div></div></div>');
						$('#infoTable>thead').append('<tr><td>id</td><td>城市名称</td><td>上级id</td><td>级别</td></tr>');
						$.ajax({
							type : "POST",
							url : "http://localhost:8181/search",
							data : {
								parentid : e.getExtData()
							},
							success : function(data) {
								for (var i = 0; i < data.length; i++) {
									var tbodyEle = '<tr><td>' + data[i].id
											+ '</td><td>' + data[i].name + '</td><td>'
											+ data[i].parentid + '</td><td>'
											+ data[i].level + '</td></tr>';
									$('#infoTable>tbody').append(tbodyEle);
								}
								$('#infoModal').modal('show');
							},
						});
					});
				});
				
				
				//定义河道部件：photo
				var photos=[];
				photos.push(createMarker(map,[ 109.405467, 38.907761 ],"img/photo.png",'photos1','0'));
				photos.push(createMarker(map,[ 104.405467, 35.907761 ],"img/photo.png",'photos2','110100000000'));
				photos.push(createMarker(map,[ 99.405467, 34.707761 ],"img/photo.png",'photos3','510000000000'));
				
				//定义复选框选中事件:开关河道部件
				$('#inlineCheckbox2').on('click',function(){
					if(this.checked){
						photos.forEach(function(e){
							e.show();
						});
					}else{
						photos.forEach(function(e){
							e.hide();
						});
					}
				});
				//创建信息photos点击事件：显示详细信息列表
				photos.forEach(function(e){
					//河道部件默认隐藏
					e.hide();
					e.on('click', function() {
						$('#infoModal').remove();
						$('body').append('<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"><div class="modal-dialog" role="document"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button><h4 class="modal-title" id="myModalLabel">详细信息</h4></div><div class="modal-body"><table id="infoTable" class="table table-striped" ><thead></thead><tbody></tbody></table></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></div></div></div></div>');
						$('#infoTable>thead').append('<tr><td>id</td><td>城市名称</td><td>上级id</td><td>级别</td></tr>');
						$.ajax({
							type : "POST",
							url : "http://localhost:8181/search",
							data : {
								parentid : e.getExtData()
							},
							success : function(data) {
								for (var i = 0; i < data.length; i++) {
									var tbodyEle = '<tr><td>' + data[i].id
											+ '</td><td>' + data[i].name + '</td><td>'
											+ data[i].parentid + '</td><td>'
											+ data[i].level + '</td></tr>';
									$('#infoTable>tbody').append(tbodyEle);
								}
								$('#infoModal').modal('show');
							}
						});
					});
				});
				
			});
	
			//初始化地图对象，加载地图
			var district, map = new AMap.Map("container", {
				mapStyle : 'amap://styles/cc431740706b0d76b4a30080013be8b5', //设置地图的显示样式
				resizeEnable : true,
				center : [ 107.968324, 38.115085 ], //地图中心点
				zooms : [ 4, 20 ],
				//地图显示的缩放级别
				zoom : 5
			});
	
			//搜索地图
			function search(cityCode) {
				if(cityCode==0){
					cityCode="100000";
				}
				map.remove(map.getAllOverlays("polygon"));
				//加载行政区划插件
				AMap.service('AMap.DistrictSearch', function() {
					var opts = {
						subdistrict : 1, //返回下一级行政区
						extensions : 'all', //返回行政区边界坐标组等具体信息
						level : 'city' //查询行政级别为 市
					};
					//实例化DistrictSearch
					district = new AMap.DistrictSearch(opts);
					district.setLevel('district');
					//行政区查询
					district.search(cityCode, function(status, result) {
						var bounds = result.districtList[0].boundaries;
						if (bounds) {
							console.log('有');
						} else {
							console.log('没有');
						}
						var polygons = [];
						if (bounds) {
							for (var i = 0, l = bounds.length; i < l; i++) {
								//生成行政区划polygon
								var polygon = new AMap.Polygon({
									map : map,
									strokeWeight : 1,
									path : bounds[i],
									fillOpacity : 0.3,
									fillColor : '#CCF3FF',
									//strokeColor: '#CC66CC'
									strokeColor : '#AAAAAA'
								});
								polygons.push(polygon);
							}
							map.setFitView(map.getAllOverlays("polygon")); //地图自适应
						}
					});
				});
			}
			
			//向行政区划树添加子节点
			function addNode(nodeId) {
				var parentid = $('#tree').data('treeview').getNode(nodeId).nodeCode;
				$.ajax({
					type : "POST",
					url : "http://localhost:8181/search",
					data : {
						parentid : parentid
					},
					success : function(data) {
						var temps = new Array(data.length);
						for (var i = 0; i < data.length; i++) {
							temps[i] = {
								text : data[i].name,
								nodeCode : data[i].id,
								nodes : [],
								parentCode : data[i].parentid
							};
							$("#tree").data('treeview').addNode(nodeId, {
								node : temps[i]
							});
						}
					}
				});
			}
			//创建信息marker方法
			function createMarker(map,position,imgPath,name,cityCode){
				return new AMap.Marker({
					map : map,
					position : position,
					icon : new AMap.Icon({
						//size: new AMap.Size(70, 80),  //图标大小
						image : imgPath,
						imageOffset : new AMap.Pixel(0, 0),
						//imageSize: new AMap.Size(20, 20),  //图标大小
					}),
					title : name,
					extData:cityCode,
				});
			}
		</script>
	</body>

</html>