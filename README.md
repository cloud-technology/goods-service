## goods-service
This project shows how to automatically generate interface and Data Transfer Object from OpenAPI yaml file as a goods service.

### OpenAPI yaml file
I put the OpenAPI specification file in specs/openapi.yaml  
``` yaml
openapi: 3.0.3
info:
  title: goods service
  version: 1.0.0
  description: |-
    This is a goods service  
    Provide price query and inventory management functions
  license:
    name: Apache 2.0
    url: 'https://www.apache.org/licenses/LICENSE-2.0'
  contact:
    name: samzhu
    url: 'https://blog.samzhu.dev/'
    email: spike19820318@gmail.com
```
I will use the gradle plugin to generate code, but only supports up to 3.0.3 specifications.

### add gradle plugin
[org.openapi.generator](https://plugins.gradle.org/plugin/org.openapi.generator)  
Currently plugin only supports 6.9, 7.0 is a problem, you can use the following commands to adjust.
``` bash
./gradlew wrapper --gradle-version 6.9
```
  
build.gradle add  
``` groovy
plugins {
	id 'org.openapi.generator' version '5.1.1'
}
```

build.gradle add Extra properties
``` groovy
ext {
	// OpenAPI input file
	set('openapiInputSpec', "${rootDir}/specs/openapi.yaml")
	// Output dir
	set('openapiOutputDir', "${rootDir}/generated/springboot")
	// If customization need add template dir
	set('openapiTemplateDir', "${rootDir}/template")
	// root package (have OpenAPI2SpringBoot.java & RFC3339DateFormat.java) 
	set('openapiInvokerPackage', "${group}")
	// Controller
	set('openapiApiPackage', "${openapiInvokerPackage}.${rootProject.name}.interfaces.rest")
	// Models
	set('openapiModelPackage', "${openapiInvokerPackage}.${rootProject.name}.interfaces.rest.dto")
    // JavaConfig
	set('openapiConfigPackage', "${openapiInvokerPackage}.configuration")
}
```
The above is roughly finished, and finally you really want to generate it directly into the project, you can directly change openapiOutputDir to the project directory

### Validate task
build.gradle add
``` groovy
openApiValidate {
	inputSpec = "${openapiInputSpec}"
}
```
executive task with this command:
``` bash
./gradlew openApiValidate
```
(Example output)
``` bash
> Task :openApiValidate
Validating spec /Users/samzhu/workspace/cloud-technology/goods-service/specs/openapi.yaml
Spec is valid.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.9/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 1s
1 actionable task: 1 executed
```

### Generate task
Generate Server-side Springboot interface & DTO  
  
build.gradle add
``` groovy
openApiGenerate {
    generatorName = "spring"
	library = "spring-boot"
	inputSpec = "${openapiInputSpec}"
    outputDir = "${openapiOutputDir}"
	templateDir = "${openapiTemplateDir}"
	invokerPackage = "${openapiInvokerPackage}"
	apiPackage = "${openapiApiPackage}"
    modelPackage = "${openapiModelPackage}"
    configOptions = [
		configPackage: "${openapiConfigPackage}",
        dateLibrary: "java8",
		openApiNullable: "false",
		disallowAdditionalPropertiesIfNotPresent: "false",
		groupId: "${group}",
        hateoas: "false",
        interfaceOnly: "true",
		licenseName: "Unlicense",
		singleContentTypes: "true", // Whether to select only one produces/consumes content-type by operation.
		title: "${rootProject.name}",
		unhandledException: "true", // Declare operation methods to throw a generic exception and allow unhandled exceptions
		useTags: "true", // use tags for creating interface and controller classnames
		useOptional: "true"
    ]
}
```
Reference:  
[openapi-generator-gradle-plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin#openapigenerate)  
[configOptions(spring)](https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/spring.md)  
  
executive task with this command:
``` bash
./gradlew openApiGenerate
```
(Example output)
``` bash
> Task :openApiGenerate
################################################################################
# Thanks for using OpenAPI Generator.                                          #
# Please consider donation to help us maintain this project 🙏                 #
# https://opencollective.com/openapi_generator/donate                          #
################################################################################
Successfully generated code to /Users/samzhu/workspace/cloud-technology/goods-service/generated/springboot

BUILD SUCCESSFUL in 1s
1 actionable task: 1 executed
```
Then you will get the result.
![https://i.imgur.com/rO1SMXV.png](https://i.imgur.com/rO1SMXV.png)

## Generate Client

### FeignClient
build.gradle add
``` groovy
task buildFeignSDK(type: org.openapitools.generator.gradle.plugin.tasks.GenerateTask){
	generatorName = "spring"
	library= "spring-cloud"
	inputSpec = "${openapiInputSpec}"
	outputDir = "${rootDir}/generated/client/feign".toString()
	templateDir = "${openapiTemplateDir}"
	invokerPackage = "${openapiInvokerPackage}"
	apiPackage = "${openapiInvokerPackage}.${rootProject.name}.application.internal.outboundservices.acl"
	modelPackage = "${openapiInvokerPackage}.shareddomain.${rootProject.name}.interfaces.rest.dto"
	configOptions = [
		configPackage: "${openapiConfigPackage}",
		dateLibrary: "java8",
		openApiNullable: "false",
		disallowAdditionalPropertiesIfNotPresent: "false",
		groupId: "${group}",
		hateoas: "false",
		interfaceOnly: "false",
		licenseName: "Unlicense",
		singleContentTypes: "true",
		title: "${rootProject.name}",
		unhandledException: "true",
		useTags: "true",
		useOptional: "true"
	]
}
```

### Angular
build.gradle add
``` groovy
task buildAngularSdk(type: org.openapitools.generator.gradle.plugin.tasks.GenerateTask){
	generatorName = "typescript-angular"
	inputSpec = "${openapiInputSpec}"
	outputDir = "${rootDir}/generated/client/angular".toString()
}
```

### Golang
build.gradle add
``` groovy
task buildGoSdk(type: org.openapitools.generator.gradle.plugin.tasks.GenerateTask){
	generatorName = "go"
	inputSpec = "${openapiInputSpec}"
	outputDir = "${rootDir}/generated/client/go".toString()
}
```

### Generate
executive task with this command:
``` bash
./gradlew buildFeignSDK buildAngularSdk buildGoSdk
```
(Example output)
``` bash
> Task :buildFeignSDK
################################################################################
# Thanks for using OpenAPI Generator.                                          #
# Please consider donation to help us maintain this project 🙏                 #
# https://opencollective.com/openapi_generator/donate                          #
################################################################################
Successfully generated code to /Users/samzhu/workspace/cloud-technology/goods-service/generated/client/feign

> Task :buildAngularSdk
################################################################################
# Thanks for using OpenAPI Generator.                                          #
# Please consider donation to help us maintain this project 🙏                 #
# https://opencollective.com/openapi_generator/donate                          #
################################################################################
Successfully generated code to /Users/samzhu/workspace/cloud-technology/goods-service/generated/client/angular

> Task :buildGoSdk
################################################################################
# Thanks for using OpenAPI Generator.                                          #
# Please consider donation to help us maintain this project 🙏                 #
# https://opencollective.com/openapi_generator/donate                          #
################################################################################
Successfully generated code to /Users/samzhu/workspace/cloud-technology/goods-service/generated/client/go

BUILD SUCCESSFUL in 1s
3 actionable tasks: 3 executed
```

Then you will get the result.
![https://i.imgur.com/O2Rrlec.png](https://i.imgur.com/O2Rrlec.png)

## Customization
In `template/pojo.mustache` I have customized to add java annotations.
``` mustache
{{#vendorExtensions.x-java-class-annotations}}
{{.}}
{{/vendorExtensions.x-java-class-annotations}}
public class {{classname}} {{#parent}}extends ....{

  {{#vendorExtensions.x-java-field-annotations}}
  {{.}}
  {{/vendorExtensions.x-java-field-annotations}}
}
```

In the OpenAPI specifications can be directly used in the definition of java annotations.
``` yaml
GoodsViewDto:
  title: goodsViewDto
  type: object
  description: Goods object view Data Transfer Object
  x-java-class-annotations:
    - '@lombok.Builder'
  properties:
    goodsId:
      type: string
      description: goods ID
      x-java-field-annotations:
        - '@javax.validation.constraints.NotBlank'
    goodsName:
      type: string
      description: goods name
```
Then you will get the result.
``` java
/**
 * Goods object view Data Transfer Object
 */
@ApiModel(description = "Goods object view Data Transfer Object")
@lombok.Builder
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-26T23:36:13.783246+08:00[Asia/Taipei]")
public class GoodsViewDto extends RepresentationModel<GoodsViewDto>   {

  @javax.validation.constraints.NotBlank
  @JsonProperty("goodsId")
  private String goodsId;
}
```

## openapi generator ignore
If it is generated to the root directory of the project, there will be more files that I don't need. At this time, I can exclude them through .openapi-generator-ignore, I will exclude the pom.xml & README.md that I don't need. Examples are as follows  

.openapi-generator-ignore
```
# add generator exclude
pom.xml
README.md
```

Because usually projects have their own custom configuration, so I set interfaceOnly to true, so that only controller interface and dto will be generated. If you are used to generating a complete project through the generator, you can try setting it to false.