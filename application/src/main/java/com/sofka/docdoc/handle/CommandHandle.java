package com.sofka.docdoc.handle;


import com.sofka.docdoc.handle.model.CategoryModel;
import com.sofka.docdoc.commands.CreateCategoryCommand;
import com.sofka.docdoc.commands.CreateDocumentCommand;
import com.sofka.docdoc.commands.CreateDownloadCommand;
import com.sofka.docdoc.commands.CreateSubCategoryCommand;
import com.sofka.docdoc.usecase.CreateDownloadUseCase;
import com.sofka.docdoc.usecase.CreateSubcategoryUseCase;
import com.sofka.docdoc.usecase.CreateCategoryUseCase;
import com.sofka.docdoc.usecase.CreateDocumentUseCase;
import com.sofka.docdoc.handle.model.DocumentModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CommandHandle {

    private final ReactiveMongoTemplate template;
    private ErrorHandler errorHandler;

    public CommandHandle(ReactiveMongoTemplate template, ErrorHandler errorHandler) {

        this.template = template;
        this.errorHandler = errorHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> createDocument(CreateDocumentUseCase useCase) {
        return route(
                POST("/document/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.save(request.bodyToMono(CreateDocumentCommand.class), "documents")
                        .then(ServerResponse.ok().build())
        );
    }
    @Bean
    public RouterFunction<ServerResponse> createDownload(CreateDownloadUseCase useCase) {
        return route(
                POST("/download/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.save(request.bodyToMono(CreateDownloadCommand.class), "downloads")
                        .then(ServerResponse.ok().build())
        );
    }

    @Bean
    public RouterFunction<ServerResponse> createCategory(CreateCategoryUseCase useCase) {
        return route(
                POST("/category/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.save(request.bodyToMono(CreateCategoryCommand.class), "categories")
                        .then(ServerResponse.ok().build())
        );
    }
    @Bean
    public RouterFunction<ServerResponse> createSubCategory(CreateSubcategoryUseCase useCase) {
        return route(
                POST("/subcategory/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.save(request.bodyToMono(CreateSubCategoryCommand.class), "subcategories")
                        .then(ServerResponse.ok().build())
        );
    }


    @Bean
    public RouterFunction<ServerResponse> deleteDocument(){
        return route(
            DELETE("/document/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.findAndRemove(
                        findDocument(request.pathVariable("id")),
                        DocumentModel.class,
                        "documents"
                ).then(ServerResponse.ok().build()));
    }
    @Bean
    public RouterFunction<ServerResponse> createCategory() {
        return route(
                POST("/category/create/test").and(accept(MediaType.APPLICATION_JSON)),
                request -> template.save(request.bodyToMono(CategoryModel.class), "categories")
                        .then(ServerResponse.ok().build())
        );
    }

   /*@Bean
    public RouterFunction<ServerResponse> updateDocument(){

        FindAndReplaceOptions options = new FindAndReplaceOptions().upsert().returnNew();
        UpdateDefinition DocumentModel;

        return route(
            PUT("/document/update/{id}").and(accept(MediaType.APPLICATION_JSON)),
            request -> template.findAndModify(
                findDocument(request.pathVariable("id")),
                updateDocument(request.body(BodyExtractor<DocumentModel>)), // No se como obtener el malditobody de la request
                DocumentModel.class,
                "documents"
            ).then(ServerResponse.ok().build())
        );

    }*/

    private Update updateDocument(DocumentModel currentDoc){

        return new Update()
                .set("name", currentDoc.getName())
                .set("subCategoryName",currentDoc.getSubCategoryName())
                .set("categoryId", currentDoc.getCategoryId())
                .set("version", currentDoc.getVersion())
                .set("pathDocument", currentDoc.getPathDocument())
                .set("blockChainId",currentDoc.getBlockChainId())
                .set("description", currentDoc.getDescription());

    }

    /* Querys utilizadas */

    private Query findDocument(String id){
        return new Query(
                Criteria.where("uuid").is(id)

        );
    }
}