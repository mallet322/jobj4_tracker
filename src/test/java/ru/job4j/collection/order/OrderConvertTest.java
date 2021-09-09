package ru.job4j.collection.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        Assert.assertThat(map.get("3sfe"), Matchers.is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenMultipleOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress0"));
        orders.add(new Order("4tyu", "Dress1"));
        orders.add(new Order("89qw", "Dress2"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        Assert.assertThat(map.get("3sfe"), Matchers.is(new Order("3sfe", "Dress0")));
        Assert.assertThat(map.get("4tyu"), Matchers.is(new Order("4tyu", "Dress1")));
        Assert.assertThat(map.get("89qw"), Matchers.is(new Order("89qw", "Dress2")));
    }

    @Test
    public void whenDuplicateOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        Assert.assertEquals(1, map.size());
        Assert.assertThat(map.get("3sfe"), Matchers.is(new Order("3sfe", "Dress")));
    }

}