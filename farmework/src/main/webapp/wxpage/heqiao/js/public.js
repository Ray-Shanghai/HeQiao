function beforeSub(obj,state,isDetail,noteType){
	var note_type="";
	var taskId=obj.value.split("=")[0];
	var noteId=obj.value.split("=")[1].split(",")[0];
	if(isDetail=="0"){
		note_type=obj.value.split("=")[1].split(",")[1];
	}
	if(isDetail=="1"){
		note_type=noteType;
	}
	
	window.location.href="advice.html?state="+state+"&pk="+taskId+"&"+noteId+","+note_type+"*"+isDetail;
}
