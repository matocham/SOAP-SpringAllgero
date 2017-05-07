var previousString = "<li><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
var nextString = "<li><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
var totalItems = 0;

String.prototype.replaceAll = function (search, replacement) {
    var target = this;
    return target.split(search).join(replacement);
};

function callForCategories(parentCat, link, baseCategoryLink) {
    $.ajax({
        url: link,
        method: "GET",
        success: function (data, status, object1) {
            console.log(data);
            var $cats = $("#catList");
            for (var i = 0; i < data.length; i++) {
                var $listElement = $("<li></li>");
                var $linkElement = $("<a></a>");
                $linkElement.text(data[i].name);
                $linkElement.attr("href", baseCategoryLink + "?category=" + data[i].id);
                $listElement.append($linkElement);
                $cats.append($listElement);
            }
        },
        error: function (object1, status, errorThrown) {
            console.log(errorThrown);
            setTimeout(callForCategories, 500, parentCat, link, baseCategoryLink);
        },
        data: {parent: parentCat},
        beforeSend: function () {
            $('#leftLoader').show();
        },
        complete: function () {
            $('#leftLoader').hide();
        },
    })
}

function callForBreadcrumbs(cat) {
    $.ajax({
        url: breadcrumbsLink,
        method: "GET",
        success: function (data, status, object1) {
            console.log(data);
            if (data) {
                var $navigation = $("#navigation");
                $navigation.show();
                var $home = $("<li></li>");
                var $homeLink = $("<a></a>");
                $homeLink.attr("href", homeLink);
                $homeLink.text("Home");
                $home.append($homeLink);
                $navigation.append($home);

                for (var i = 0; i < data.length; i++) {
                    var $listElement = $("<li></li>");
                    if (i != data.length - 1) {
                        var $linkElement = $("<a></a>");
                        $linkElement.text(data[i].categoryName);
                        $linkElement.attr("href", baseCategoryLink + "?category=" + data[i].id);
                        $listElement.append($linkElement);
                    } else {
                        $listElement.text(data[i].categoryName);
                        $listElement.attr("class", "active");
                    }

                    $navigation.append($listElement);
                }
            }
        },
        error: function (object1, status, errorThrown) {
            $("#navigation").hide();
            console.log(errorThrown);
            setTimeout(callForBreadcrumbs, 500, parentCat);
        },
        data: {category: cat}
    })
}

function callForAdds(parentCat, offsetVal, sizeVal) {
    $("#addverts").find("div").remove();
    $.ajax({
        url: addsLink,
        method: "GET",
        success: function (data, status, object1) {
            console.log(data);
            totalItems = data.totalCount;
            if (totalItems == 0) {
                $("#noItems").show();
            } else {
                refreshNavigation();

                var adds = $("#addverts");
                adds.find("div").remove();
                var downloadedAdds = data.adds;
                if (downloadedAdds) {
                    var addTemplate = doT.template(addTemplateString);
                    for (var i = 0; i < downloadedAdds.length; i++) {
                        downloadedAdds[i].addLink = baseAddLink + "?add=" + downloadedAdds[i].id;
                        if (!downloadedAdds[i].imageUrl) {
                            downloadedAdds[i].imageUrl = noImageLink;
                        }
                        var result = addTemplate(downloadedAdds[i]);
                        adds.append($.parseHTML(result));
                    }
                }
            }
        },
        error: function (object1, status, errorThrown) {
            console.log(errorThrown);
            setTimeout(callForAdds, 500, parentCat, addsLink, baseAddLink, offsetVal, sizeVal);
        },
        data: {category: parentCat, offset: offsetVal, size: sizeVal},
        beforeSend: function () {
            $('#catLoader').show();
        },
        complete: function () {
            $('#catLoader').hide();
        },
    })
}

function callForSearchResults(query, offsetVal, sizeVal) {
    $("#addverts").find("div").remove();
    $.ajax({
        url: searchLink,
        method: "GET",
        success: function (data, status, object1) {
            console.log(data);
            totalItems = data.totalCount;
            if (totalItems == 0) {
                $("#noSearchResults").show();
            } else {
                refreshNavigationInSearch();

                var adds = $("#addverts");
                adds.find("div").remove();
                var downloadedAdds = data.adds;
                if (downloadedAdds) {
                    var addTemplate = doT.template(addTemplateString);
                    for (var i = 0; i < downloadedAdds.length; i++) {
                        downloadedAdds[i].addLink = baseAddLink + "?add=" + downloadedAdds[i].id;
                        if (!downloadedAdds[i].imageUrl) {
                            downloadedAdds[i].imageUrl = noImageLink;
                        }
                        var result = addTemplate(downloadedAdds[i]);
                        adds.append($.parseHTML(result));
                    }
                }
            }
        },
        error: function (object1, status, errorThrown) {
            console.log(errorThrown);
            setTimeout(callForSearchResults, 500, query, offsetVal, sizeVal);
        },
        data: {q: query, offset: offsetVal, size: sizeVal},
        beforeSend: function () {
            $('#searchLoader').show();
        },
        complete: function () {
            $('#searchLoader').hide();
        },
    })
}

function refreshNavigation() {
    $(".pagination li").remove();
    if (totalItems > 0) {
        var $previous = $.parseHTML(previousString);
        var $next = $.parseHTML(nextString);
        var currentPage = parseInt(offset / itemsPageSize) + 1;
        var $paginationList = $(".pagination");
        var numberOfPages = Math.ceil(totalItems / itemsPageSize);
        if (numberOfPages > 1) {
            $paginationList.append($previous);
            for (var i = 1; i < numberOfPages + 1; i++) {
                var $paginationElement = $("<li></li>");
                if (i != 1 && i != numberOfPages) {
                    if (i - currentPage < 6 && i - currentPage >-5) {
                        var $linkElement = $("<a></a>");
                        $paginationElement.append($linkElement);
                        $linkElement.attr("href", "#");
                        $linkElement.text(i);
                        if (currentPage == i) {
                            $paginationElement.attr("class", "active");
                        }else {
                            $paginationElement.removeAttr("class");
                        }

                        $paginationList.append($paginationElement);
                        $linkElement.on("click", function () {
                            var selectedValue = $(this).text();
                            offset = (selectedValue - 1) * itemsPageSize;
                            callForAdds(parentCategory, offset, itemsPageSize);
                        })
                    } else if(i<currentPage){
                        i= currentPage-5;
                        $paginationElement.attr("class", "disabled");
                        var $linkElement = $("<a></a>");
                        $paginationElement.append($linkElement);
                        $linkElement.attr("href", "#");
                        $linkElement.text("...");
                        $paginationList.append($paginationElement);
                    } else if(i>currentPage){
                        i= numberOfPages-1;
                        $paginationElement.attr("class", "disabled");
                        $paginationElement.append($linkElement);
                        $linkElement.attr("href", "#");
                        $linkElement.text("...");
                        $paginationList.append($paginationElement);
                    }
                } else {
                    var $linkElement = $("<a></a>");
                    $paginationElement.append($linkElement);
                    $linkElement.attr("href", "#");
                    $linkElement.text(i);
                    if (currentPage == i) {
                        $paginationElement.attr("class", "active");
                    } else {
                        $paginationElement.removeAttr("class");
                    }
                    $paginationList.append($paginationElement);
                    $linkElement.on("click", function () {
                        var selectedValue = $(this).text();
                        offset = (selectedValue - 1) * itemsPageSize;
                        callForAdds(parentCategory, offset, itemsPageSize);
                    })
                }
            }
            $paginationList.append($next);

            $paginationList.find("a[aria-label=Previous]").on("click", function () {
                if (offset > 0) {
                    $("#addverts li").remove();
                    offset = offset - itemsPageSize;
                    callForAdds(parentCategory, offset, itemsPageSize);
                }
            });

            $paginationList.find("a[aria-label=Next]").on("click", function () {
                if (offset + itemsPageSize < totalItems) {
                    $("#addverts li").remove();
                    offset = offset + itemsPageSize;
                    callForAdds(parentCategory, offset, itemsPageSize);
                }
            });
        }
    }
}

function refreshNavigationInSearch() {
    $(".pagination li").remove();
    if (totalItems > 0) {
        var $previous = $.parseHTML(previousString);
        var $next = $.parseHTML(nextString);
        var currentPage = parseInt(offset / itemsPageSize) + 1;
        var $paginationList = $(".pagination");
        var numberOfPages = Math.ceil(totalItems / itemsPageSize);
        if (numberOfPages > 1) {
            $paginationList.append($previous);
            for (var i = 1; i < numberOfPages + 1; i++) {
                var $paginationElement = $("<li></li>");
                if (i != 1 && i != numberOfPages) {
                    if (i - currentPage < 6 && i - currentPage >-5) {
                        var $linkElement = $("<a></a>");
                        $paginationElement.append($linkElement);
                        $linkElement.attr("href", "#");
                        $linkElement.text(i);
                        if (currentPage == i) {
                            $paginationElement.attr("class", "active");
                        }else {
                            $paginationElement.removeAttr("class");
                        }

                        $paginationList.append($paginationElement);
                        $linkElement.on("click", function () {
                            var selectedValue = $(this).text();
                            offset = (selectedValue - 1) * itemsPageSize;
                            callForSearchResults(query, offset, itemsPageSize);
                        })
                    } else if(i<currentPage){
                        i= currentPage-5;
                        $paginationElement.attr("class", "disabled");
                        var $linkElement = $("<a></a>");
                        $paginationElement.append($linkElement);
                        $linkElement.attr("href", "#");
                        $linkElement.text("...");
                        $paginationList.append($paginationElement);
                    } else if(i>currentPage){
                        i= numberOfPages-1;
                        $paginationElement.attr("class", "disabled");
                        $paginationElement.append($linkElement);
                        $linkElement.attr("href", "#");
                        $linkElement.text("...");
                        $paginationList.append($paginationElement);
                    }
                } else {
                    var $linkElement = $("<a></a>");
                    $paginationElement.append($linkElement);
                    $linkElement.attr("href", "#");
                    $linkElement.text(i);
                    if (currentPage == i) {
                        $paginationElement.attr("class", "active");
                    } else {
                        $paginationElement.removeAttr("class");
                    }
                    $paginationList.append($paginationElement);
                    $linkElement.on("click", function () {
                        var selectedValue = $(this).text();
                        offset = (selectedValue - 1) * itemsPageSize;
                        callForSearchResults(query, offset, itemsPageSize);
                    })
                }
            }
            $paginationList.append($next);

            $paginationList.find("a[aria-label=Previous]").on("click", function () {
                if (offset > 0) {
                    $("#addverts li").remove();
                    offset = offset - itemsPageSize;
                    callForSearchResults(query, offset, itemsPageSize);
                }
            });

            $paginationList.find("a[aria-label=Next]").on("click", function () {
                if (offset + itemsPageSize < totalItems) {
                    $("#addverts li").remove();
                    offset = offset + itemsPageSize;
                    callForSearchResults(query, offset, itemsPageSize);
                }
            });
        }
    }
}

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};

var addTemplateString = "<div class='panel panel-default'>" +
    "<div class='row addContainer vertical-align'>" +
    "<div class='col-md-2 centered'>" +
    "<a href='{{=it.addLink}}' class='thumbnail autoMargin'>" +
    "<img src='{{=it.imageUrl}}'/>" +
    "</a>" +
    "</div>" +
    "<div class='col-md-10'>" +
    "<div class='h3 addHeader'>" +
    "<a href='{{=it.addLink}}'>{{=it.title}}</a>" +
    "</div>" +
    "<div class='h6 addState'>" +
    "{{=it.state}}" +
    "</div>" +
    "<div class='h3 addPrice'>" +
    "<b>{{=it.price}}</b>" +
    "<p class='h6 addPriceType'>" +
    "{{=it.priceType}}" +
    "</p>" +
    "</div>" +
    "<div class='h6 addEndDate'><span>{{=it.lastTime}}</span>&nbsp;<span>{{=it.endDate}}</span></div>" +
    "<div class='h6 addPriceWithDelivery'><b>{{=it.priceWithDelivery}}</b> z dostawą</div>" +
    "</div>" +
    "</div>" +
    "</div>";