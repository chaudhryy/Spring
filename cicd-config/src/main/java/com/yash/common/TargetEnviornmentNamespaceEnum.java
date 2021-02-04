package com.yash.common;

public enum TargetEnviornmentNamespaceEnum {

    Staging("Staging"),
    Production("Production")
    ,Nft("intg-nft");


    TargetEnviornmentNamespaceEnum(String namespace){
        this.namespace = namespace;
    }

    String namespace;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
