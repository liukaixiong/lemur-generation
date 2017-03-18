define(['knockout'], function(ko) {
	var Pager = function() {
		self = this;
		// 分页
		this.curPage = ko.observable(1);
		this.pages = ko.observable(0);
		this.total = ko.observable(0);
		this.lineNumber = [1,2]; // 显示行数
		this.curNumber = ko.observableArray([20]); // 显示行数选择监听
		this.turnNumber = ko.observable(); // 跳转页数
		/** ****************底部分页栏********************** */
		// 每页显示的条数选项，发生改变时，重新请求数据
		this.computedNum = function(self) {
			$('#content-footer select[name="lineNumber"]').change(function() {
				self.curPage(1);
				self.getData();
			})
		}
		// 上一页
		this.prePage = function(self) {
			var curPage = self.curPage();
			if(curPage <= 1) {
				return;
			}
			self.curPage(curPage - 1);
			self.getData();
		};
		// 下一页
		this.nextPage = function(self) {
			var curPage = self.curPage();
			var pages = self.pages();
			if(curPage >= pages) {
				return;
			}
			self.curPage(curPage + 1);
			self.getData();
		};
		// 跳页操作
		this.turnTo = function(self) {
			var num = self.turnNumber();
			var pages = self.pages();
			var reg = /^[0-9]*[1-9][0-9]*$/;
			if(num <= 0 || num > pages || !reg.test(num)) {
				dialog.alert('请输入正确的页码')
			} else {
				self.curPage(parseInt(num));
				self.getData();
			}
		};
		/** ***************底部分页栏end********************** */
	}
	return new Pager();
});