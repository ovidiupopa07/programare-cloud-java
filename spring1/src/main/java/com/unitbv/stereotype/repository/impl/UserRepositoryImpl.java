package com.unitbv.stereotype.repository.impl;

import com.unitbv.stereotype.model.User;
import com.unitbv.stereotype.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<Integer> findAll() {
        return null;
    }

    @Override
    public List<Integer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Integer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Integer> findAllById(Iterable<User> users) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(User user) {

    }

    @Override
    public void delete(Integer entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends User> users) {

    }

    @Override
    public void deleteAll(Iterable<? extends Integer> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Integer> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Integer> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Integer> findById(User user) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(User user) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Integer> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Integer> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Integer> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<User> users) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Integer getOne(User user) {
        return null;
    }

    @Override
    public Integer getById(User user) {
        return null;
    }

    @Override
    public <S extends Integer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Integer> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Integer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Integer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Integer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Integer> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Integer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
