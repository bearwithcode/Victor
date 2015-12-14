$(document).ready(function(){
    $('#apn_pert').click(function(){
        setTimeout(function(){
            getNodes("apn");
        }, 100);
        if (typeof myAPNDiagram !== 'undefined') {
            if (myAPNDiagram) {
                myAPNDiagram.div = null;
            }
        }
    });
    $('#project_target_days').keyup(displayZValue);
    $('#view_z_graph_button').click(function(){
        $('#z_graph_img').slideToggle();
    });
});

function getNodes (load_what) {
    var nodesAndLinksArray;
    var task_array;

    $.ajax({
        method: "POST",
        url: "includes/request_tasks.php",
        data: {project_id: $('#project_name_big').attr('project_id')},
        success: function(tasks){
            nodesAndLinksArray = computeTasks(tasks);
            task_array = tasks;
        },
        dataType: "json",
        async: false //not recommended but no choice
    });

    switch(load_what){
        case "apn":
            initAPN(nodesAndLinksArray[0], nodesAndLinksArray[1]);
            initPERT(nodesAndLinksArray[0], task_array);
            break;
        case "gantt":
            initGantt(nodesAndLinksArray[0], nodesAndLinksArray[1], task_array);
            break;
    }
}

function initPERT (nodeDataArray, tasks) {
    //do the PERT analysis based on the critical path
    var expected_time = 0;
    var standard_deviation = 0;

    //ignore the start and end nodes
    for (var i = 1; i < nodeDataArray.length - 1; i++) {

        //if the node is part of the critical path...
        if (nodeDataArray[i].critical) {
            expected_time += getActivityExpectedTime(parseInt(tasks[i - 1].optimisticdays),
                                parseInt(tasks[i - 1].daysrequired), 
                                parseInt(tasks[i - 1].pessimisticdays));
            standard_deviation += getActivityStdDvn(parseInt(tasks[i - 1].pessimisticdays),
                                parseInt(tasks[i - 1].optimisticdays));
        }
    }

    standard_deviation = Math.sqrt(standard_deviation);

    //sneaky stuff storing these as globals in the HTML file
    $('#expected_time').text(expected_time);
    $('#standard_deviation').text(standard_deviation);
}

function getActivityExpectedTime(a, m, b){
    return (a + (4 * m) + b) / 6.0;
}

function getActivityStdDvn(b, a){
    var s = (b - a) / 6.0;
    return (s * s);
}

function displayZValue () {
    var expected_time = parseFloat($('#expected_time').text());
    var standard_deviation = parseFloat($('#standard_deviation').text());
    var project_target_days = parseFloat($('#project_target_days').val());

    var z_val = (project_target_days - expected_time) / standard_deviation;

    $('#pert_output').text('There is about a ' + getZChance(z_val) + ' chance of not meeting the target of ' + project_target_days + ' days.');
}

function getZChance(Z){
    var chance = "";
    
    if(Z < -3.00){
        chance = "100%";
    }
    else if(Z < -2.75){
        chance = "99%";
    }
    else if(Z < -2.50){
        chance = "98%";
    }
    else if(Z < -2.25){
        chance = "97%";
    }
    else if(Z < -2.00){
        chance = "96%";
    }
    else if(Z < -1.75){
        chance = "95%";
    }
    else if(Z < -1.50){
        chance = "93%";
    }
    else if(Z < -1.25){
        chance = "90%";
    }
    else if(Z < -1.00){
        chance = "84%";
    }
    else if(Z < -0.75){
        chance = "78%";
    }
    else if(Z < -0.50){
        chance = "69%";
    }
    else if(Z < -0.25){
        chance = "59%";
    }
    else if(Z < 0){
        chance = "49%";
    }
    else if(Z < 0.25){
        chance = "39%";
    }
    else if(Z < 0.50){
        chance = "30%";
    }
    else if(Z < 0.75){
        chance = "24%";
    }
    else if(Z < 1.00){
        chance = "17%";
    }
    else if(Z < 1.25){
        chance = "11%";
    }
    else if(Z < 1.5){
        chance = "6%";
    }
    else if(Z < 1.75){
        chance = "5%";
    }
    else if(Z < 2){
        chance = "4%";
    }
    else if(Z < 2.25){
        chance = "3%";
    }
    else if(Z < 2.5){
        chance = "2%";
    }
    else if(Z < 2.75){
        chance = "1%";
    }
    else{
        chance = "0%";
    }

    return chance;
}

function computeTasks (tasks) {
    var nodeDataArray = [];
    var linkDataArray = [];

    //create the Start node
    nodeDataArray[0] = {
        key: 0,
        text: "Start",
        length: 0,
        earlyStart: 0,
        lateFinish: 0,
        critical: true
    };

    $.ajax({
        type: "POST",
        url: "includes/request_dependencies.php",
        data: {project_id: $('#project_name_big').attr('project_id')},
        success: function(dependencies){
            var max_node = 0;

            //populate linkDataArray array with dependencies from dataabase
            for (var i = 0; i < dependencies.length; i++) {
                linkDataArray[i] = {
                    from: parseInt(dependencies[i].precedingTask),
                    to: parseInt(dependencies[i].taskID)
                };

                //get the max number of the nodes
                if (max_node < parseInt(dependencies[i].taskID)) {
                    max_node = parseInt(dependencies[i].taskID);
                }
            }

            //computes forward pass
            for (var i = 0; i < tasks.length; i++) {
                var early_start = 0; 

                //goes through each dependency to find the latest earlyFinish time
                for (var j = 0; j < dependencies.length; j++) { 

                    //dependency found for the current key
                    if ((i + 1) == dependencies[j].taskID) {

                        //get the earlyFinish time of the candidate node
                        var candidate_node_finish = parseInt(nodeDataArray[dependencies[j].precedingTask].earlyFinish);
                       
                        //if the finish time of the candidate node is greater than the current start time, replace.
                        if (early_start < candidate_node_finish) {
                            early_start = candidate_node_finish;
                        }
                    }
                }
                var days_required = parseInt(tasks[i].daysrequired);
                nodeDataArray[i + 1] = {
                    key: i + 1,
                    text: tasks[i].taskName,
                    length: days_required,
                    earlyStart: early_start,
                    earlyFinish: early_start + days_required
                }; 
            }

            //We need to know what nodes preceed the finish node so we do some calculations
            //to know the nodes that precede the finish node and the earliest start time
            //that the Finish node can have


            //find nodes which don't link to any proceeding node
            //link these nodes to the Finish node
            //for all nodes from the max

            var finish_node_early_start = 0;
            for (var i = max_node; i > 0; i--) {

                //for each node to check if it has a next
                //we assume that the node does not have a next
                var has_next = false;

                //check the "from" attribute of each element of the linkDataArray
                for (var j = 0; j < linkDataArray.length; j++) {

                    //if the "from" attribute matches the current node
                    if (linkDataArray[j].from == i) {
                        //then this node has a next
                        has_next = true;
                        break;
                    }
                }

                //if node does not have next
                //1. compute the latest start time
                //2. link it to finish node
                if (!has_next) {

                    //Find the latest early start of the preceding nodes to the finish node
                    //get the earlyFinish time of the candidate node
                    for (var j = 0; j < nodeDataArray.length; j++) {
                        if (nodeDataArray[j].key == i) {
                            var candidate_node_finish = parseInt(nodeDataArray[j].earlyFinish);
                           
                            //if the finish time of the candidate node is greater than the current start time, replace.
                            if (finish_node_early_start < candidate_node_finish) {
                                finish_node_early_start = candidate_node_finish;
                            }
                        } 
                    }

                    var current_length = linkDataArray.length;
                    linkDataArray[current_length] = {
                        from: i,
                        to: (tasks.length + 1)
                    };
                }
            }

            //create the Finish node
            nodeDataArray[tasks.length + 1] = {
                key: tasks.length + 1,
                text: "Finish",
                length: 0,
                earlyStart: finish_node_early_start,
                lateStart: finish_node_early_start,
                earlyFinish: finish_node_early_start,
                lateFinish: finish_node_early_start,
                critical: true
            };

            //backward pass

            //for all nodes in the nodeDataArray array
            //ignore the start and end nodes
            for (var i = nodeDataArray.length - 1; i > 0; i--) { 
                var late_finish = finish_node_early_start; 

                //goes through each element in linkDataArray to find the nodes that link to the
                //current element and get the latest lateFinish time
                for (var j = 0; j < linkDataArray.length; j++) {

                    //dependency found for the current key
                    if ((i - 1) == linkDataArray[j].from) {
                        //get the lateStart time of the "To" node
                        var candidate_node_finish = parseInt(nodeDataArray[linkDataArray[j].to].lateStart);
                       
                        //if the finish time of the candidate node is greater than the current start time, replace.
                        if (late_finish > candidate_node_finish) {
                            late_finish = candidate_node_finish;
                        }
                    }
                }
                nodeDataArray[i - 1].lateStart = late_finish - nodeDataArray[i - 1].length;
                nodeDataArray[i - 1].lateFinish = late_finish;
            }
        },
        dataType: "json",
        async: false //not recommended but no choice
    });

    //determine critical path
    for (var i = 0; i < nodeDataArray.length; i++) {

        var slack = nodeDataArray[i].lateFinish - (nodeDataArray[i].earlyStart + nodeDataArray[i].length);

        if (slack == 0) {
            nodeDataArray[i].critical = true;
        } else{
            nodeDataArray[i].critical = false;
        }
    }

    var nodesAndLinks = [nodeDataArray, linkDataArray];
    return nodesAndLinks;
}

function initAPN(nodeDataArray, linkDataArray){
    var $ = go.GraphObject.make;  // for more concise visual tree definitions

    //global
    myAPNDiagram =
      $(go.Diagram, "apn_div",
        {
          initialAutoScale: go.Diagram.Uniform,
          initialContentAlignment: go.Spot.Center,
          layout: $(go.LayeredDigraphLayout)
        });

    // The node template shows the activity name in the middle as well as
    // various statistics about the activity, all surrounded by a border.
    // The border's color is determined by the node data's ".critical" property.
    // Some information is not available as properties on the node data,
    // but must be computed -- we use converter functions for that.
    myAPNDiagram.nodeTemplate =
      $(go.Node, "Auto",
        $(go.Shape, "Rectangle",  // the border
          { fill: "white" },
          new go.Binding("stroke", "critical",
                         function (b) { return (b ? "red" : "blue"); })),
        $(go.Panel, "Table",
          { padding: 0.5 },
          $(go.RowColumnDefinition, { column: 1, separatorStroke: "black" }),
          $(go.RowColumnDefinition, { column: 2, separatorStroke: "black" }),
          $(go.RowColumnDefinition, { row: 1, separatorStroke: "black", background: "white", coversSeparators: true }),
          $(go.RowColumnDefinition, { row: 2, separatorStroke: "black" }),
          $(go.TextBlock,
            new go.Binding("text", "earlyStart"),
            { row: 0, column: 0, margin: 5, textAlign: "center" }),
          $(go.TextBlock,
            new go.Binding("text", "length"),
            { row: 0, column: 1, margin: 5, textAlign: "center" }),
          $(go.TextBlock,  // earlyFinish
            new go.Binding("text", "",
                           function(d) { return (d.earlyStart + d.length); }),
            { row: 0, column: 2, margin: 5, textAlign: "center" }),

          $(go.TextBlock,
            new go.Binding("text", "text"),
            { row: 1, column: 0, columnSpan: 3, margin: 5,
              textAlign: "center", font: "bold 14px sans-serif" }),

          $(go.TextBlock,  // lateStart
            new go.Binding("text", "",
                           function(d) { return (d.lateFinish - d.length); }),
            { row: 2, column: 0, margin: 5, textAlign: "center" }),
          $(go.TextBlock,  // slack
            new go.Binding("text", "",
                           function(d) { return (d.lateFinish - (d.earlyStart + d.length)); }),
            { row: 2, column: 1, margin: 5, textAlign: "center" }),
          $(go.TextBlock,
            new go.Binding("text", "lateFinish"),
            { row: 2, column: 2, margin: 5, textAlign: "center" })
        )  // end Table Panel
      );  // end Node

    // The link data object does not have direct access to both nodes
    // (although it does have references to their keys: .from and .to).
    // This conversion function gets the GraphObject that was data-bound as the second argument.
    // From that we can get the containing Link, and then the Link.fromNode or .toNode,
    // and then its node data, which has the ".critical" property we need.
    //
    // But note that if we were to dynamically change the ".critical" property on a node data,
    // calling myAPNDiagram.model.updateTargetBindings(nodedata) would only update the color
    // of the nodes.  It would be insufficient to change the appearance of any Links.
    function linkColorConverter(linkdata, elt) {
      var link = elt.part;
      if (!link) return "blue";
      var f = link.fromNode;
      if (!f || !f.data || !f.data.critical) return "blue";
      var t = link.toNode;
      if (!t || !t.data || !t.data.critical) return "blue";
      return "red";  // when both Link.fromNode.data.critical and Link.toNode.data.critical
    }

    // The color of a link (including its arrowhead) is red only when both
    // connected nodes have data that is ".critical"; otherwise it is blue.
    // This is computed by the binding converter function.
    myAPNDiagram.linkTemplate =
      $(go.Link,
        $(go.Shape,
          { isPanelMain: true },
          new go.Binding("stroke", "", linkColorConverter)),
        $(go.Shape,  // arrowhead
          { toArrow: "Standard", stroke: null },
          new go.Binding("fill", "", linkColorConverter))
      );

    myAPNDiagram.model = new go.GraphLinksModel(nodeDataArray, linkDataArray);

    // create an unbound Part that acts as a "legend" for the diagram
    myAPNDiagram.add(
      $(go.Node, "Auto",
        $(go.Shape, "Rectangle",  // the border
          { fill: "lightblue" } ),
        $(go.Panel, "Table",
          $(go.RowColumnDefinition, { column: 1, separatorStroke: "black" }),
          $(go.RowColumnDefinition, { column: 2, separatorStroke: "black" }),
          $(go.RowColumnDefinition, { row: 1, separatorStroke: "black", background: "lightblue", coversSeparators: true }),
          $(go.RowColumnDefinition, { row: 2, separatorStroke: "black" }),
          $(go.TextBlock, "Early Start",
            { row: 0, column: 0, margin: 5, textAlign: "center" }),
          $(go.TextBlock, "Duration",
            { row: 0, column: 1, margin: 5, textAlign: "center" }),
          $(go.TextBlock, "Early Finish",
            { row: 0, column: 2, margin: 5, textAlign: "center" }),

          $(go.TextBlock, "Activity Name",
            { row: 1, column: 0, columnSpan: 3, margin: 5,
              textAlign: "center", font: "bold 14px sans-serif" }),

          $(go.TextBlock, "Late Start",
            { row: 2, column: 0, margin: 5, textAlign: "center" }),
          $(go.TextBlock, "Float",
            { row: 2, column: 1, margin: 5, textAlign: "center" }),
          $(go.TextBlock, "Late Finish",
            { row: 2, column: 2, margin: 5, textAlign: "center" })
        )  // end Table Panel
      ));

} //end init function