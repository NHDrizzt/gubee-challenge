package org.rokol.domain.dto;

import org.rokol.domain.model.Market;
import org.rokol.domain.model.Stack;

import java.util.List;

public class FilterProduct {
    private List<Market> market;
    private List<Stack> stack;

    public FilterProduct() {
    }

    public List<Market> getMarket() {
        return market;
    }

    public void setMarket(List<Market> market) {
        this.market = market;
    }

    public List<Stack> getStack() {
        return stack;
    }

    public void setStack(List<Stack> stack) {
        this.stack = stack;
    }
}
