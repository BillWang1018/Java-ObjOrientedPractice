package TeamProject;

public enum Messages {
    FUNCTION_INFO("""
            ##====={ MENU }======##
            || A. deposit        ||
            || B. select product ||
            || C. remove product ||
            || D. check out      ||
            || E. leave          ||
            ##===================##
            """),
    DEPOSIT_INFO("""
            ##={ Deposit Mode }=##
            || B. insert bill   ||
            || C. insert coin   ||
            || ---              ||
            || ! anys to exit   ||
            ##==================##
            """),
    DEPOSIT_B_INFO("""
            ##==={ Depositting Bills }===##
            || Avalible bills:           ||
            || $ 1, 5, 10, 20   (dollar) ||
            || ---                       ||
            || enter 0 to exit           ||
            ##===========================##
            """),
    DEPOSIT_C_INFO("""
            ##==={ Depositting Coins }===##
            || Avalible coins:           ||
            || ¢ 5, 10, 25        (cent) ||
            || ---                       ||
            || enter 0 to exit           ||
            ##===========================##
            """),
    PRODUCT_INFO("""
            ##========={ Products }=========##
            || A. Coco Cola                 ||
            || B. Minute Maid Orange Juice  ||
            || C. Evian Mineral Water       ||
            || D. M&M's Chocolate           ||
            || E. Hershey's Chocolate Bar   ||
            || F. Oreo Cookies              ||
            || G. Doritos Tortilla Chips    ||
            || H. Pringles Potato Chips     ||
            || ---                          ||
            || enter Q to exit              ||
            ##==============================##
            """),
    ADDING_TITLE("""
            ##=========>> ADDING <<=========##
            ||              vv              ||
            """),
    REMOVING_TITLE("""
            ##========>> REMOVING <<========##
            ||              vv              ||
            """)
    ;


    private String str;
    private Messages(String str)  {
        this.str = str;
    }
    @Override
    public String toString() {
        return this.str;
    }
}
