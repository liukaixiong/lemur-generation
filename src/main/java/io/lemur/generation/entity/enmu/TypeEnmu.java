package io.lemur.generation.entity.enmu;

/**
 * 生成类型
 * @author JueYue
 * @date 2014年12月25日
 */
public enum TypeEnmu {

    Entity("entity.ftl","/entity","/%sEntity.java"), 
    IService("iservice.ftl","/service","/I%sService.java"), 
    ServiceImpl("serviceImpl.ftl","/service/impl","/%sServiceImpl.java"), 
    Controller("controller.ftl","/controller","/%sController.java"), 
    Repository("repository.ftl","/repository","/%sRepository.java"), 
    AddJsp("addjsp.ftl","/page","/%sAdd.jsp"), 
    UpdateJsp("updatejsp.ftl","/page","/%sUpdate.jsp"), 
    ListJsp("listjsp.ftl","","/%sList.jsp");
    
    private String value;
    private String srcPackage;
    private String suffix;

    private TypeEnmu(String value,String srcPackage,String suffix) {
        this.value = value;
        this.srcPackage = srcPackage;
        this.suffix = suffix;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSrcPackage() {
        return srcPackage;
    }

    public void setSrcPackage(String srcPackage) {
        this.srcPackage = srcPackage;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}
