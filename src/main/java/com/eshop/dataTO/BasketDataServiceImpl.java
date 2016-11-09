package com.eshop.dataTO;

import com.eshop.Interface.BasketDataService;
import com.eshop.configuration.EmailComponent;
import com.eshop.mapper.BasketMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * Created by raks on 20.09.16.
 */
@Component
public class BasketDataServiceImpl implements BasketDataService {

//    private JdbcTemplate jdbcTemplate;

    static final Logger log = Logger.getLogger(BasketDataService.class);

    @Autowired
    BasketMapper basketMapper;

    @Autowired
    EmailComponent email;
//    public BasketDataServiceImpl(JdbcOperations jdbcOperations){
//        this.jdbcTemplate = (JdbcTemplate) jdbcOperations;
//    }

    @Override
    public List findAllItemsForUser(Integer id_user){

        String token = UUID.randomUUID().toString();

        String  textMsg = "<h1>Dear, friend!</h1>" +
                "<p>This message for confirm your email!</p>" +
                "<p>Please confirm your email clicked this link <a href=localhost:8080/"+token+"></p>";

//        List<Map<String,Object>> rowsQuery = jdbcTemplate.queryForList(querySelect, new Object[] {id_user});
//        for (Map row : rowsQuery) {
//            Basket basket = new Basket();
//            basket.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
//            basket.setName_seller(String.valueOf(row.get("NAME_SELLER")));
//            basket.setFull_user(String.valueOf(row.get("NAME_USER")));
//            basket.setName_goods(String.valueOf(row.get("NAME_GOODS")));
//            basket.setPrice_things(Integer.parseInt(String.valueOf(row.get("PRICE_THINGS"))));
//            basket.setCount_things(Integer.parseInt(String.valueOf(row.get("COUNT_THINGS"))));
//            dataList.add(basket);
//        }
        dataList.addAll(basketMapper.findBasketUserByIdUser(id_user));

        email.sendMessage("werwolf959@gmail.com", textMsg, "Confirm message");

        return dataList;
    }
//    @Override
//    public List deleteItemUser(String id_user, Integer basket){
//        System.out.println("Delete Item in table basket!");
//        jdbcTemplate.update(deleteQuery, new Object[] {id_user, basket});
//        log.debug(dataList.stream().filter(basket1 -> basket.equals(basket1.getId())));
//        dataList.remove(dataList.stream().filter(basket1 -> basket.equals(basket1.getId())).findAny().orElse(null));
//        log.info(dataList.isEmpty());
//        return dataList;
//    }
//
//    @Override
//    public String addItemUserInBasket(String id_user, Objects objects){
//        jdbcTemplate.update(insertQuery, new Object[]{objects.hashCode()});
//        return "Success insert";
//    }
}
