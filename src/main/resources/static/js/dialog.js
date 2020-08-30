/**
 *
 */

const UPDATE_MESSAGE = "更新処理を実行します。\nよろしいです？"
$('.update-action').click(function() {
	if(!confirm(UPDATE_MESSAGE)){
		// キャンセルの処理
		return false;
	}
});
