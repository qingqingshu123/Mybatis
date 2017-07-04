/**
 * 调用后台批量删除方法
 * @param bathPath
 */
function deleteBatch(basePath){
    $("#mainForm").attr("action", basePath+"DeleteBatch.action");
    $("#mainForm").submit();
}