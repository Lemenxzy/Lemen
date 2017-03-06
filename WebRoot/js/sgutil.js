function randomColor(){
	var r = Math.floor(Math.random()*256);
	var g = Math.floor(Math.random()*256);
	var b = Math.floor(Math.random()*256);
	return "rgb("+r+","+g+","+b+")";//IE7不支出rgb
}

function randomColor16(){
	//0-255	
	var r = random(255).toString(16);
	var g = random(255).toString(16);
	var b = random(255).toString(16);
	//255的数字转换成十六进制
	if(r.length<2)r = "0"+r;
	if(g.length<2)g = "0"+g;
	if(b.length<2)b = "0"+b;
	return "#"+r+g+b;
}

function random(num){
	return Math.floor(Math.random()*(num+1));
}

function randomRange(start,end){
	return Math.floor(Math.random()*(end-start+1))+start;
};


/**
 * 判断非空
 * 
 * @param val
 * @returns {Boolean}
 */
function isEmpty(val) {
	val = $.trim(val);
	if (val == null)
		return true;
	if (val == undefined || val == 'undefined')
		return true;
	if (val == "")
		return true;
	if (val.length == 0)
		return true;
	if (!/[^(^\s*)|(\s*$)]/.test(val))
		return true;
	return false;
}

function isNotEmpty(val) {
	return !isEmpty(val);
};

//时间的判断
function getTimeFormat(startTime){
	var startTimeMills = startTime.getTime();
	var endTimeMills = new Date().getTime();
	var diff = parseInt((endTimeMills - startTimeMills)/1000);//秒
	var day_diff = parseInt(Math.floor(diff/86400));//天
	var buffer = Array();
	if(day_diff<0){
		return "[error],时间越界...";
	}else{
		if(day_diff==0 && diff<60){
			if(diff<=0)diff=1;
			buffer.push(diff+"秒前");
		}else if(day_diff==0 && diff<120){
			buffer.push("1 分钟前");
		}else if(day_diff==0 && diff<3600){
			buffer.push(Math.round(Math.floor(diff/60))+"分钟前");
		}else if(day_diff==0 && diff<7200){
			buffer.push("1小时前");
		}else if(day_diff==0 && diff<86400){
			buffer.push(Math.round(Math.floor(diff/3600))+"小时前");
		}else if(day_diff==1){
			buffer.push("1天前");
		}else if(day_diff<7){
			buffer.push(day_diff+"天前");
		}else if(day_diff <30){
			buffer.push(Math.round(Math.ceil( day_diff / 7 )) + " 星期前");
		}else if(day_diff >=30 && day_diff<=179 ){
			buffer.push(Math.round(Math.ceil( day_diff / 30 )) + "月前");
		}else if(day_diff >=180 && day_diff<365){
			buffer.push("半年前");
		}else if(day_diff>=365){
			buffer.push(Math.round(Math.ceil( day_diff /30/12))+"年前");
		}
	}
	return buffer.toString();
};

/*判断是否为合适长度 6-32 位*/
function isProperLen(o){
	var len=o.replace(/[^\x00-\xff]/g,"11").length;
	if(len>32||len<6){
		return false;
	}else{
		return true;
	}
}
/*判断是否为Email*/
function isEmail(o){
	var reg=/^\w+\@[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$/i;
	return reg.test(o);
}
/*判断url是否正确*/
function isUrl(o){
	var reg=/^(http\:\/\/)?(\w+\.)+\w{2,3}((\/\w+)+(\w+\.\w+)?)?$/;
	return reg.test(o);
}
/*判断是否为电话号码 可以是手机或 固定电话*/
function isPhone(v){
	var reg=/((15[89])\d{8})|((13)\d{9})|(0[1-9]{2,3}\-?[1-9]{6,7})/i;
	if(reg.test(v)){
		return true;
	}else{
		return false;
	}
}
function isNum(o){
	var reg=/[^\d]+/;
	return reg.test(o)?false:true;
}
function isChinese(o){
	var reg=/^[\u4E00-\u9FA5]+$/;
	return reg.test(o);
}

