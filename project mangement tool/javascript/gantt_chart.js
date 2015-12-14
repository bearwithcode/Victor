$(document).ready(function(){
    $('#gantt_c').click(function(){
        setTimeout(function(){
            getNodes("gantt");
        }, 100);
        if (typeof myGanttDiagram !== 'undefined') {
            if (myGanttDiagram) {
                myGanttDiagram.div = null;
            }
        }
    });
});

function initGantt(nodeDataArray, linkDataArray, tasks){
  var $ = go.GraphObject.make;  // for conciseness in defining templates

  myGanttDiagram =
    $(go.Diagram, "gantt_chart_div",  // Diagram refers to its DIV HTML element by id
      {
        _widthFactor: 1,        // a scale for the nodes' positions and widths
        isReadOnly: true,       // deny the user permission to alter the diagram or zoom in or out
        allowZoom: false,
        "grid.visible": true,  // display a grid in the background of the diagram
        "grid.gridCellSize": new go.Size(30, 150)
      });

  // create the template for the standard nodes
  myGanttDiagram.nodeTemplateMap.add("",
    $(go.Node, "Auto",
      // links come from the right and go to the left side of the top of the node
      { fromSpot: go.Spot.Right, toSpot: new go.Spot(0.001, 0, 11, 0) },
      $(go.Shape, "Rectangle",
        { height: 15 },
        new go.Binding("fill", "color"),
        new go.Binding("width", "width", function (w) { return scaleWidth(w); })),
      $(go.TextBlock,
        { margin: 2, alignment: go.Spot.Left },
        new go.Binding("text", "key")),
      // using a function in the Binding allows the value to
      // change when Diagram.updateAllTargetBindings is called
      new go.Binding("location", "loc",
                     function (l) { return new go.Point(scaleWidth(l.x), l.y); })
    )
  );

  // create the template for the start node
  myGanttDiagram.nodeTemplateMap.add("start",
    $(go.Node,
      { fromSpot: go.Spot.Right, toSpot: go.Spot.Top, selectable: false },
      $(go.Shape, "Diamond",
        { height: 15, width: 15 }),
      // make the location of the start node is not scalable
      new go.Binding("location", "loc")
    ));

  // create the template for the end node
  myGanttDiagram.nodeTemplateMap.add("end",
    $(go.Node,
      { fromSpot: go.Spot.Right, toSpot: go.Spot.Top, selectable: false },
      $(go.Shape, "Diamond",
        { height: 15, width: 15 }),
      // make the location of the end node (with location.x < 0) scalable
      new go.Binding("location", "loc",
                     function(l) {
                       if (l.x >= 0) return new go.Point(scaleWidth(l.x), l.y);
                       else return l;
                     }
      )
    )
  );

  myGanttDiagram.nodeTemplateMap.add("date",
        $(go.Part,
          { selectable: false },
          new go.Binding("location", "loc",
                         function (l) { return new go.Point(scaleWidth(l.x), l.y); }),
          $(go.TextBlock,
            new go.Binding("text", "key"))
        ));

  //create the link template
  myGanttDiagram.linkTemplate =
    $(go.Link,
      {
        routing: go.Link.Orthogonal,
        corner: 3, toShortLength: 2,
        selectable: false
      },
      $(go.Shape,
        { isPanelMain: true, strokeWidth: 2 }),
      $(go.Shape,
        { toArrow: "OpenTriangle" })
    );  

  var nodes = [];
  var linkdata = [];
  var ystart = 40; //the height of the bar
  var end_node_x = 0;
  var date_format = "DD-MM-YYYY";
  var current_task_date = moment(getProjectStartDate(), date_format);
  
  //ignore start and end nodes
  for(var i = 1; i < nodeDataArray.length - 1; i++){
    //retrieve data from DB
    
    nodes.push({ //push each task into node list
      key: nodeDataArray[i].text,
      color: "coral",
      width: 10 * nodeDataArray[i].length,
      loc: new go.Point(scaleWidth(nodeDataArray[i].earlyStart * 10), ystart)
    });
    
    if(nodeDataArray[i].earlyStart + nodeDataArray[i].length > end_node_x){
      end_node_x = nodeDataArray[i].earlyStart + nodeDataArray[i].length;
    }
    

    nodes.push({ //push each task into node list
      key: current_task_date.format(date_format),
      category: "date",
      loc: new go.Point(scaleWidth(nodeDataArray[i].earlyStart * 10), 0)
    });

    current_task_date.add(nodeDataArray[i].length, 'days');
    ystart += 20;
  } //end for loop
  
  nodes.push({ //define the start node
    key: "Start",
    category: "start",
    loc: new go.Point(-15, 20)
  });
  
  nodes.push({ //define the end node
    key: "Finish",
    category: "end",
    loc: new go.Point(scaleWidth(end_node_x * 10), ystart)
  });
  
  for (var i = 0; i < linkDataArray.length; i++) {
    linkdata[i] = {
      from: nodeDataArray[linkDataArray[i].from].text,
      to: nodeDataArray[linkDataArray[i].to].text
    };
  }

  myGanttDiagram.model = new go.GraphLinksModel(nodes, linkdata);
}
 
// scale the number according to the current widthFactor
function scaleWidth(num) {
  return num * myGanttDiagram._widthFactor;
}

// change the grid's cell size and the widthFactor,
// then update Bindings to scale the widths and positions of nodes
function rescale() {
  var val = parseFloat(document.getElementById("widthSlider").value);
  myGanttDiagram.startTransaction("rescale");
  myGanttDiagram.grid.gridCellSize = new go.Size(val, 150);
  myGanttDiagram._widthFactor = val / 30;
  myGanttDiagram.updateAllTargetBindings();
  myGanttDiagram.commitTransaction("rescale");
}

function getProjectStartDate(){
  return $('#project_start_date').text().trim();
}