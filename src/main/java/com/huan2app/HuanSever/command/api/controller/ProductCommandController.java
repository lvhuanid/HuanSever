package com.huan2app.HuanSever.command.api.controller;

import com.huan2app.HuanSever.command.api.commands.CreateProductCommand;
import com.huan2app.HuanSever.command.api.model.ProductRestMoael;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    private CommandGateway commandGateway;

    public ProductCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addProduct(@RequestBody ProductRestMoael productRestMoael) {
//上传提交测试、、
        CreateProductCommand createProductCommand =
                CreateProductCommand.builder()
                        .productId(UUID.randomUUID().toString())
                        .name(productRestMoael.getName())
                        .price(productRestMoael.getPrice())
                        .quantity(productRestMoael.getQuantity())
                        .build();
        String result = commandGateway.sendAndWait(createProductCommand);

        return result;
    }
}
