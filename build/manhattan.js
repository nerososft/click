var manhattan = new Object({
    URL: {
        BASE_URL: function() {
            return "http://47.88.77.83:8080/data/data/";
        },

        MANHATTAN: function(cancerType, dataType) {
            //http://47.88.77.83:8080/data/data/gbm/1/c/l/mean/bychromosomes

            var url = manhattan.URL.BASE_URL() + cancerType + "/" + dataType + "/bypanhattan";
            console.log("url", url);
            return url;
        }
    },
    OPERATE: {
        getmanhattan: function(cancerType, dataType) {
            $("#echarts").html('<div class="spinner">' +
                '<div class="rect1"></div>' +
                '<div class="rect2"></div>' +
                '<div class="rect3"></div>' +
                '<div class="rect4"></div>' +
                '<div class="rect5"></div>' +
                '</div><p class="col-md-12" style="text-align:center;color:rgb(61,132,193);">Loading~~~</p>');
            var url = manhattan.URL.MANHATTAN(cancerType, dataType);

            $.get(url, {}, function(result, status) {
                if (status) {
                    if (result == null) {
                        alert("error null");
                    } else {
                        var gene = [];
                        for (var a in result.data) { //--->样本正常否
                            var prop = [];
                            for (var b in result.data[a]) { //---->样本

                                var tmp = result.data[a][b][0];
                                result.data[a][b][0] = result.data[a][b][1];
                                result.data[a][b][1] = result.data[a][b][2];
                                result.data[a][b][2] = tmp;
                                prop.push([parseInt(result.data[a][b].ucStart), result.data[a][b].pvalue]);
                            }
                            gene.push(prop);
                        }
                        manhattan.View.draw(gene);
                    }
                } else {
                    alert("there is something wrong when request " + url + ",data:" + data);
                }
            });
        }
    },
    View: {
        init: function() {
            /**初始化配置项ui*/
            /**/
            $("#pixelRatio_select").html("");
            /**/
            for (var i = 1; i < 50; i++) {
                /**/
                $("#pixelRatio_select").append("<option class='col-md-12' value='" + i + "'>" + i + "</option>");
                /**/
            }
            /**/
            $("#saveType_select").html("");
            /**/
            $("#saveType_select").append("<option class='col-md-12' value='png'>png</option>");
            /**/
            $("#saveType_select").append("<option class='col-md-12' value='jpeg'>jpeg</option>");
            /**/
            /**/
            $("#pointStyle_select").html("");
            /**/
            $("#pointStyle_select").append("<option class='col-md-12' value='circle'>circle</option>");
            /**/
            $("#pointStyle_select").append("<option class='col-md-12' value='rect'>rect</option>");
            /**/
            $("#pointStyle_select").append("<option class='col-md-12' value='roundRect'>roundRect</option>");
            /**/
            $("#pointStyle_select").append("<option class='col-md-12' value='triangle'>triangle</option>");
            /**/
            $("#pointStyle_select").append("<option class='col-md-12' value='diamond'>diamond</option>");
            /**/
            $("#pointStyle_select").append("<option class='col-md-12' value='pin'>pin</option>");
            /**/
            $("#pointStyle_select").append("<option class='col-md-12' value='arrow'>arrow</option>");
            /**/
            /**/
            $("#pointSize_select").html("");
            /**/
            $("#pointSize_select").append("<option class='col-md-12' value='5'>5</option>");
            /**/
            for (var i = 1; i < 20; i++) {
                /**/
                $("#pointSize_select").append("<option class='col-md-12' value='" + i + "'>" + i + "</option>");
                /**/
            }
            /**/
            $("#pointColor_select").html("");
            /**/
            $("#boxColor_select").html("");
            /**/
            $("#boxStyle_select").html("");
            /**/
            $("#lineColor_select").html("");
            /**/
            $("#lineStyle_select").html("");
            /**/
            var color_arr = ["Black", "AliceBlue", "AntiqueWhite", "Aqua", "Aquamarine",
                /**/
                "Azure", "Beige", "Bisque", "Black", "BlanchedAlmond", "Blue", "BlueViolet",
                /**/
                "Brown", "BurlyWood", "CadetBlue", "Chartreuse", "Chocolate", "Coral", "CornflowerBlue", "Cornsilk", "Crimson",
                /**/
                "Cyan", "DarkBlue", "DarkCyan", "DarkGoldenRod", "DarkGray", "DarkGreen",
                /**/
                "DarkKhaki", "DarkMagenta", "DarkOliveGreen", "Darkorange", "DarkOrchid", "DarkRed",
                /**/
                "DarkSalmon", "DarkSeaGreen", "DarkSlateBlue", "DarkSlateGray", "DarkTurquoise",
                /**/
                "DarkViolet", "DeepPink", "DeepSkyBlue", "DimGray", "DodgerBlue", "Feldspar",
                /**/
                "FireBrick", "FloralWhite", "ForestGreen", "Fuchsia", "Gainsboro", "GhostWhite",
                /**/
                "Gold", "GoldenRod", "Gray", "Green", "GreenYellow", "HoneyDew", "HotPink",
                /**/
                "IndianRed", "Indigo", "Ivory", "Khaki", "Lavender", "LavenderBlush", "LawnGreen",
                /**/
                "LemonChiffon", "LightBlue", "LightCoral", "LightCyan", "LightGoldenRodYellow", "LightGrey",
                /**/
                "LightGreen", "LightPink", "LightSalmon", "LightSeaGreen",
                /**/
                "LightSkyBlue", "LightSlateBlue", "LightSlateGray", "LightSteelBlue",
                /**/
                "LightYellow", "Lime", "LimeGreen", "Linen", "Magenta", "Maroon",
                /**/
                "MediumAquaMarine", "MediumBlue", "MediumOrchid", "MediumPurple",
                /**/
                "MediumSeaGreen", "MediumSlateBlue", "MediumSpringGreen", "MediumTurquoise",
                /**/
                "MediumVioletRed", "MidnightBlue", "MintCream", "MistyRose", "Moccasin", "NavajoWhite",
                /**/
                "Navy", "OldLace", "Olive", "OliveDrab", "Orange", "OrangeRed", "Orchid",
                /**/
                "PaleGoldenRod", "PaleGreen", "PaleTurquoise", "PaleVioletRed", "PapayaWhip",
                /**/
                "PeachPuff", "Peru", "Pink", "Plum", "PowderBlue", "Purple", "Red",
                /**/
                "RosyBrown", "RoyalBlue", "SaddleBrown", "Salmon", "SandyBrown",
                /**/
                "SeaGreen", "SeaShell", "Sienna", "Silver", "SkyBlue", "SlateBlue",
                /**/
                "SlateGray", "Snow", "SpringGreen", "SteelBlue", "Tan", "Teal",
                /**/
                "Thistle", "Tomato", "Turquoise", "Violet", "VioletRed",
                /**/
                "Wheat", "White", "WhiteSmoke", "Yellow", "YellowGreen"
            ];
            /**/
            for (var i = 0; i < color_arr.length; i++) {
                /**/
                $("#pointColor_select").append("<option class='col-md-12' value='" + color_arr[i] + "'>" + color_arr[i] + "</option>");
                /**/
                /**/
                $("#boxColor_select").append("<option class='col-md-12' value='" + color_arr[i] + "'>" + color_arr[i] + "</option>");
                /**/
                /**/
                $("#lineColor_select").append("<option class='col-md-12' value='" + color_arr[i] + "'>" + color_arr[i] + "</option>");
                /**/
                /**/
            }
            /**/
            $("#boxStyle_select").append("<option class='col-md-12' value='solid'>solid</option>");
            /**/
            $("#boxStyle_select").append("<option class='col-md-12' value='dashed'>dashed</option>");
            /**/
            $("#boxStyle_select").append("<option class='col-md-12' value='dotted'>dotted</option>");
            /**/
            $("#lineStyle_select").append("<option class='col-md-12' value='solid'>solid</option>");
            /**/
            $("#lineStyle_select").append("<option class='col-md-12' value='dashed'>dashed</option>");
            /**/
            $("#lineStyle_select").append("<option class='col-md-12' value='dotted'>dotted</option>");
            /**/
            var cancer_arr = [
                /**/
                "Acute Myeloid Leukemia [LAML]",
                /**/
                "Adrenocortical carcinoma [ACC]",
                /**/
                "Bladder Urothelial Carcinoma [BLCA]",
                /**/
                "Brain Lower Grade Glioma [LGG]",
                /**/
                "Breast invasive carcinoma [BRCA]",
                /**/
                "Cervical squamous cell carcinoma and endocervical adenocarcinoma [CESC]",
                /**/
                "Cholangiocarcinoma [CHOL]",
                /**/
                "Colon adenocarcinoma [COAD]",
                /**/
                "Esophageal carcinoma [ESCA]",
                /**/
                "FFPE Pilot Phase II [FPPP]",
                /**/
                "Glioblastoma multiforme [GBM]",
                /**/
                "Head and Neck squamous cell carcinoma [HNSC]",
                /**/
                "Kidney Chromophobe [KICH]",
                /**/
                "Kidney renal clear cell carcinoma [KIRC]",
                /**/
                "Kidney renal papillary cell carcinoma [KIRP]",
                /**/
                "Liver hepatocellular carcinoma [LIHC]",
                /**/
                "Lung adenocarcinoma [LUAD]",
                /**/
                "Lung squamous cell carcinoma [LUSC]",
                /**/
                "Lymphoid Neoplasm Diffuse Large B-cell Lymphoma [DLBC]",
                /**/
                "Mesothelioma [MESO]",
                /**/
                "Ovarian serous cystadenocarcinoma [OV]",
                /**/
                "Pancreatic adenocarcinoma [PAAD]",
                /**/
                "Pheochromocytoma and Paraganglioma [PCPG]",
                /**/
                "Prostate adenocarcinoma [PRAD]",
                /**/
                "Rectum adenocarcinoma [READ]",
                /**/
                "Sarcoma [SARC]",
                /**/
                "Skin Cutaneous Melanoma [SKCM]",
                /**/
                "Stomach adenocarcinoma [STAD]",
                /**/
                "Testicular Germ Cell Tumors [TGCT]",
                /**/
                "Thymoma [THYM]",
                /**/
                "Thyroid carcinoma [THCA]",
                /**/
                "Uterine Carcinosarcoma [UCS]",
                /**/
                "Uterine Corpus Endometrial Carcinoma [UCEC]",
                /**/
                "Uveal Melanoma [UVM]"
                /**/
            ];
            /**/ //dlbc acc laml meso ov tgct ucs uvm无正常样本
            /**/
            $("#cancername").html("");
            /**/
            for (var i = 0; i < cancer_arr.length; i++) {
                /**/
                var r = /\[(.+?)\]/; //正则获取方括号内容并转为小写
                /**/
                $("#cancername").append("<option class='col-md-12' value='" + cancer_arr[i].match(r)[1].toLowerCase() + "'>" + cancer_arr[i] + "</option>");
                /**/
            }
            /**结束*/

        },
        getRandomColor: function() {

            return (function(m, s, c) {
                return (c ? arguments.callee(m, s, c - 1) : '#') +
                    s[m.floor(m.random() * 16)]
            })(Math, '0123456789abcdef', 5)
        },
        draw: function(dataAll) {
            console.log(dataAll);
            var saveName = "xx";
            var saveType = "png";
            var pixelRatio = 1;
            var symbolSize = 5;
            var itemColor = "#0000ff";
            var XMAX = 0;
            var YMAX = 0;
            var YMIN = 10;
            var XMIN = 10;
            var data = [];
            /**
             *data结构
             *List<List<Point>>
             *Point 结构
             * x y sampleId
             */

            var series = [];
            var lgd = [];

            var big = [];
            for (var i = 0; i < dataAll.length; i++) {
                var bb = 0;
                for (var j = 0; j < dataAll[i].length; j++) {

                    if (dataAll[i][j][1] < YMIN) {
                        YMIN = dataAll[i][j][1];
                    }
                    if (dataAll[i][j][1] > YMAX) {
                        YMAX = dataAll[i][j][1];
                    }
                    if (dataAll[i][j][0] > XMAX) {
                        XMAX = dataAll[i][j][0];
                    }
                    if (dataAll[i][j][0] < XMIN) {
                        XMIN = dataAll[i][j][0];
                    }
                    if (dataAll[i][j][0] > bb) {
                        bb = dataAll[i][j][0];
                    }
                }
                big.push(bb);
                lgd.push({
                    name: "chr" + i
                });
            }
            console.log(YMAX);
            console.log(big);
            var bbig = [];
            for (var i = 0; i < big.length; i++) {
                var a = 0;
                for (var j = 0; j < i; j++) {
                    a = a + parseInt(big[j]);
                }
                bbig.push(a);

            }
            console.log(bbig);

            for (var i = 0; i < dataAll.length; i++) {
                var color = manhattan.View.getRandomColor();
                var data = [];
                for (var j = 0; j < dataAll[i].length; j++) {
                    data.push([{
                        coord: [bbig[i] + dataAll[i][j][0], 0],
                        symbol: 'none',
                        lineStyle: {
                            normal: {
                                width: 1,
                                color: color
                            }
                        }
                    }, {
                        coord: [bbig[i] + dataAll[i][j][0], dataAll[i][j][1]],
                        symbol: 'none'
                    }]);
                }
                series.push({
                    name: "chr" + i,
                    type: 'scatter',
                    xAxisIndex: 0,
                    yAxisIndex: 0,
                    markLine: {
                        lineStyle: {
                            normal: {
                                type: 'solid'
                            }
                        },
                        label: {
                            normal: {
                                show: false
                            }
                        },
                        data: data
                    }
                });
            }



            option = {
                title: {
                    text: $("#cancername").val(),
                    x: 'center',
                    y: 0
                },
                legend: {
                    data: lgd,
                    align: 'left'
                },
                grid: [
                    { x: '7%', y: '7%', width: '90%', height: '90%' }
                ],
                tooltip: {
                    formatter: 'Group {a}: ({c})'
                },
                xAxis: [
                    { gridIndex: 0, min: XMIN, max: bbig[bbig.length - 1] }
                ],
                yAxis: [
                    { gridIndex: 0, min: YMIN, name: "pvalue", max: YMAX }
                ],
                series: series
            };

            var myChart = echarts.init(document.getElementById('echarts'));

            myChart.setOption(option);

        }
    }
});