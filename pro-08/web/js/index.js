function delFruit(fid){
    if(window.confirm("是否删除")){
        window.location.href='del?fid='+fid;
    }
}
function pgDown(pageNo){
    window.location.href='index?pageNo='+pageNo;
}