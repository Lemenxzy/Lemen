$(function() {
    $("#content").keyup(function() {
        var opid = $("body").data("opid");
        if (window.localStorage) {
            localStorage.setItem("content_" + opid, $(this).val())
        }
    })
});
$(function() {
    if (window.localStorage) {
        var opid = $("body").data("opid");
        var contxt = localStorage.getItem("content_" + opid);
        $("#content").val(contxt)
    }
});
var src = [];
$(function() {
    var content = $("#contentbox").data("cotnt");
    var contnetBox = document.getElementById("contentbox");
    if (content.indexOf("#") > 0) {
        var strs = new Array();
        strs = content.split("#");
        for (i = 0; i < strs.length; i++) {
            if (i % 2 == 0) {
                contnetBox.innerHTML += "<p class='music'>" + " <span class='glyphicon glyphicon-music'></span> " + strs[i] + "<a href='javascript:void(0)' onclick='stopaudio(this)' class='stop'><span class='glyphicon glyphicon-pause'></span></a>" + "<a href='javascript:void(0)' onclick='playaudio(this)' class='play'  id=" + (i / 2) + "><span class='glyphicon glyphicon-headphones'></span></a>" + "</p>"
            }
        }
        for (i = 0; i < strs.length; i++) {
            if (i % 2 == !0) {
                src.push(strs[i])
            }
        }
    } else {
        $("#contentbox").html(content)
    }
});
var playadudio = document.getElementById("audiomp3");

function test(index) {
    var zindex = $("a.play").length - 1;
    if (index > zindex) {
        index = 0
    }
    playadudio.src = src[index];
    playadudio.play()
}
$(function() {
    var index = 0;
    playadudio.src = src[index];
    playadudio.play();
    playadudio.addEventListener("ended", function() {
        var c = ++index;
        test(c)
    }, false)
});

function stopaudio() {
    playadudio.pause()
}

function playaudio(obj) {
    var index = obj.id;
    playadudio.src = src[index];
    playadudio.play()
}
$(function() {
    var itcount = $("#content_list").data("itcount");
    $("#page").tzPage(itcount, {
        num_edge_entries: 4,
        num_display_entries: 4,
        num_edge_entries: 0,
        current_page: 0,
        showGo: false,
        showSelect: false,
        items_per_page: 10,
        prev_text: "前一页",
        next_text: "后一页",
        callback: function(pageNo, psize) {
            loadData(pageNo * psize, psize)
        }
    });

    function loadData(pno, psize) {
        var opid = $("body").data("opid");
        $.ajax({
            type: "post",
            url: basePath + "/template/talkcomment.jsp",
            data: {
                "id": opid,
                "pno": pno,
                "psize": psize
            },
            success: function(data) {
                $("#content_list").html(data)
            }
        })
    }
    $("#btn").on("click", talking);

    function talking() {
        var ctk = $("#content").val();
        if (isEmpty(ctk)) {
            alert("请输入评论内容！");
            $("#content").focus();
            return
        }
        $("#btn").off("click").text("评论中..");
        var cid = $("#btn").data("cid");
        var content = ctk;
        $("#content").val("");
        $.ajax({
            type: "post",
            url: basePath + "/server/talkdata.jsp",
            data: {
                "ctk": ctk,
                "cid": cid
            },
            error: function() {
                $("#btn").on("click", talking).text("评论")
            },
            success: function(data) {
                data = data.trim();
                $("#btn").on("click", talking).text("评论");
                if (data == "nologin") {
                    window.location.href = basePath + "/login.jsp"
                } else {
                    if (data == "success") {
                        if (window.localStorage) {
                            localStorage.removeItem("content_" + cid)
                        }
                        location.reload()
                    } else {
                        if (data == "null") {
                            alert("请输入评论内容！")
                        } else {
                            if (data == "fail") {
                                alert("系统错误，评论失败")
                            }
                        }
                    }
                }
            }
        })
    }
});
$(function() {
    var topmenu = $("#fixmenu");
    var topmenu_top = topmenu.offset().top;
    $(window).scroll(function() {
        reset_topmenu_top(topmenu, topmenu_top)
    })
});

function reset_topmenu_top(topmenu, topmenu_top) {
    var document_scroll_top = $(document).scrollTop();
    if (document_scroll_top > topmenu_top) {
        topmenu.addClass("navbar-fixed-top");
        $("#top").fadeIn("slow")
    } else {
        topmenu.removeClass("navbar-fixed-top");
        $("#top").stop(true, true).fadeOut("slow")
    }
}
$("#top").on("click touchmove", function() {
    $("html,body").animate({
        scrollTop: 0
    }, "slow")
});
$(".scrollLoading").scrollLoading();
