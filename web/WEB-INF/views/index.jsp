<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<body>

<script src="https://www.google.com/jsapi"></script>
<script>
    google.load("visualization", "1", {packages: ["corechart"]});
    google.setOnLoadCallback(drawChart);
    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Hill height/rain height','Hill', 'Rain'],
            // TODO: Replace with model foreach
            ['3/5', 3, 0],
            ['3/5', 2, 1],
            ['3/5', 1, 2],
            ['3/5', 4, 0],
            ['3/5', 3, 0],
            ['3/5', 2, 1],
            ['3/5', 1, 2],
            ['3/5', 4, 0]

        ]);

        var options = {
            legend: {position: 'top', maxLines: 2},
            bar: {groupWidth: '100%'},
            isStacked: true
        };
        var chart = new google.visualization.ColumnChart(document.getElementById('hills'));
        chart.draw(data, options);
    }
</script>

<div id="hills" align="center" style="width: 80%; height: 50%;"></div>
<div align="center">
    <%--TODO: check input--%>
    <spring:form method="post" modelAttribute="hills" action="getWater" align="center">
        Put hills height(ex. 2, 5, 6, 1, 7):<spring:input path="hillsHeights"/>

        <spring:button>Fill pools</spring:button>
    </spring:form>
</div>
</body>
</html>