package com.example.corebase.infrastructure.constant;

public enum SequencesConstant {

    CODE_MNG("CODE_MNG", "CODE"),
    FILE_MNG("FILE_MNG", "FILE"),
    CPS_MENU_MNG("CPS_MENU_MNG", "CMM"),
    TABLE_THREE("TBL_THREE", "T3");

    private final String tableName;
    private final String prefix;

    SequencesConstant(String tableName, String prefix) {
        this.tableName = tableName;
        this.prefix = prefix;
    }

    public String getTableName() {
        return tableName;
    }

    public String getPrefix() {
        return prefix;
    }
}
