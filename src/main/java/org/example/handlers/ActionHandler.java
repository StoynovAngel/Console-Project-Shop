package org.example.handlers;

import org.example.actions.OrderAction;
import org.example.actions.ProductAction;
import org.example.actions.UserAction;

public class ActionHandler {
    public final UserAction userAction;
    public final ProductAction productAction;
    public final OrderAction orderAction;

    public ActionHandler(UserAction userAction, ProductAction productAction, OrderAction orderAction) {
        this.userAction = userAction;
        this.productAction = productAction;
        this.orderAction = orderAction;
    }
}
