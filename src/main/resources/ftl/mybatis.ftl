<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${params.javaPackage}.repository.${params.packageName}.${params.entityName}Repository">
	
	<resultMap type="${params.entityName}Entity" id="${params.entityName}EntityMap">
		<#list table.fields as v>
			<result column="${v.fieldName ?upper_case}" property="${v.name}"/>
		</#list>
	</resultMap>

</mapper>