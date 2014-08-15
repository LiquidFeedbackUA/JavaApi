package com.github.kindrat.liquidfeedback.api.endpoint.dto;

import java.io.Serializable;
import java.util.Set;

public class MemberRequestDto implements Serializable {

    private static final long serialVersionUID = 2953534133424799176L;

    private Set<Integer> ids;
    private String textSearch;
    private Boolean searchActive;
    private Boolean useNameOrder;
    private Boolean useCreatedOrder;

    public MemberRequestDto() {
    }

    public MemberRequestDto(Set<Integer> ids, String textSearch, Boolean searchActive, Boolean useNameOrder, Boolean useCreatedOrder) {
        this.ids = ids;
        this.textSearch = textSearch;
        this.searchActive = searchActive;
        this.useNameOrder = useNameOrder;
        this.useCreatedOrder = useCreatedOrder;
    }

    public Set<Integer> getIds() {
        return ids;
    }

    public void setIds(Set<Integer> ids) {
        this.ids = ids;
    }

    public String getTextSearch() {
        return textSearch;
    }

    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }

    public Boolean getSearchActive() {
        return searchActive;
    }

    public void setSearchActive(Boolean searchActive) {
        this.searchActive = searchActive;
    }

    public Boolean getUseNameOrder() {
        return useNameOrder;
    }

    public void setUseNameOrder(Boolean useNameOrder) {
        this.useNameOrder = useNameOrder;
    }

    public Boolean getUseCreatedOrder() {
        return useCreatedOrder;
    }

    public void setUseCreatedOrder(Boolean useCreatedOrder) {
        this.useCreatedOrder = useCreatedOrder;
    }

    @Override
    public String toString() {
        return "MemberRequestDto{" +
                "ids=" + ids +
                ", textSearch='" + textSearch + '\'' +
                ", searchActive=" + searchActive +
                ", useNameOrder=" + useNameOrder +
                ", useCreatedOrder=" + useCreatedOrder +
                '}';
    }
}
