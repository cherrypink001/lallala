
    /**
     * initMap()方法的作用是初始化本关grade 游戏地图，清空悔棋信息列表list。 调用
     * getMapSizeAndPosition(方法获取游戏区域大小及显示游戏的左上角位置( leftX, leftY )。
     */
    public void initMap() {
        // 获取当前关卡的地图数据
        map = MapFactory.getMap(grade);
        // 清除上一关保存的回退地图数据，即清空list集合的内容
        list.clear();
        // 初始化地图行列数和左上角起始坐标位置
        getMapSizeAndPosition();
        // 获取角色的坐标位置
        getManPosition();
    }

    /**
     * getManPosition()方法的作用是获取工人的当前位置(row,column)。
     */
    public void getManPosition() {
        // 即遍历地图数组map中存在那个值等于MANXXX（MAN_DOWN表示向下的人；MAN_UP表示向上的人）的情况，即表示该位置是人站立的位置，这个由地图数据扫描得出
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == MAN_DOWN || map[i][j] == MAN_DOWN_ON_END
                        || map[i][j] == MAN_UP || map[i][j] == MAN_UP_ON_END
                        || map[i][j] == MAN_LEFT || map[i][j] == MAN_LEFT_ON_END
                        || map[i][j] == MAN_RIGHT || map[i][j] == MAN_RIGHT) {
                    // 保存人的位置，i表示第几行，j表示第几列，而且是从0开始的
                    this.row = i;
                    this.column = j;
                    break;
                }
            }
        }
    }

    /**
     * getMapSizeAndPosition()方法用来获取游戏区域大小及显示游戏的左上角位置( lefX, leftY )。
     */
    private void getMapSizeAndPosition() {
        // 初始化mapRow和mapColumn，表示地图的行列数
        this.mapRow = map.length;
        this.mapColumn = map[0].length;
        // 初始化leftX和leftY，即计算左上角的位置，
        this.leftX = (width - map[0].length * MOVE_PIXEL) / 2;
        this.leftY = (height - map.length * MOVE_PIXEL) / 2;
    }
