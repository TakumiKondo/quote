/**
 *
 */

const UPDATE_MESSAGE = "更新処理を実行します。\nよろしいです？"
const INSERT_MESSAGE = "登録処理を実行します。\nよろしいです？"
const DELETE_MESSAGE = "削除処理を実行します。\nよろしいです？"

$('.update-action').click(function() {
	if(!confirm(UPDATE_MESSAGE)){
		// キャンセルの処理
		return false;
	}
});


$('.insert-action').click(function() {
	if(!confirm(INSERT_MESSAGE)){
		return false;
	}
});

$('.delete-action').click(function() {
	if(!confirm(DELETE_MESSAGE)){
		return false;
	}
});