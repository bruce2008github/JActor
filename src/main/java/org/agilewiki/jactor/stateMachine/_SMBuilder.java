/*
 * Copyright 2011 Bill La Forge
 *
 * This file is part of AgileWiki and is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License (LGPL) as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * or navigate to the following url http://www.gnu.org/licenses/lgpl-2.1.txt
 *
 * Note however that only Scala, Java and JavaScript files are being covered by LGPL.
 * All other files are covered by the Common Public License (CPL).
 * A copy of this license is also included and can be
 * found as well at http://www.opensource.org/licenses/cpl1.0.txt
 */
package org.agilewiki.jactor.stateMachine;

import org.agilewiki.jactor.Actor;
import org.agilewiki.jactor.JAIterator;
import org.agilewiki.jactor.ResponseProcessor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates and runs a state machine.
 */
abstract public class _SMBuilder {
    /**
     * The operations to be performed by a state machine.
     */
    final private ArrayList<_Operation> operations = new ArrayList<_Operation>();

    /**
     * The labels assigned to various indexes into the operations.
     */
    final private HashMap<String, Integer> labels = new HashMap<String, Integer>();

    /**
     * Returns the location assigned to a label.
     *
     * @param label The name assigned to a location,
     * @return An index, or null.
     */
    final public Integer resolve(String label) {
        return labels.get(label);
    }

    /**
     * Returns the number of operations.
     *
     * @return The number of operations.
     */
    final public int operationsSize() {
        return operations.size();
    }

    /**
     * Returns an operation.
     *
     * @param ndx An index.
     * @return The selected operation.
     */
    final public _Operation getOperation(int ndx) {
        return operations.get(ndx);
    }

    /**
     * Add an _Operation to the operations.
     *
     * @param operation An operation performed by a state machine.
     */
    final public void add(_Operation operation) {
        operations.add(operation);
    }

    /**
     * Create a _SendVV.
     *
     * @param targetActor The actor which is to receive the message.
     * @param request     The request.
     */
    final public void _send(Actor targetActor, Object request) {
        new _SendVV(this, targetActor, request, null);
    }

    /**
     * Create a _SendVV.
     *
     * @param targetActor The actor which is to receive the message.
     * @param request     The request.
     * @param resultName  The name of the result, or null.
     */
    final public void _send(Actor targetActor, Object request, String resultName) {
        new _SendVV(this, targetActor, request, resultName);
    }

    /**
     * Create a _SendFF.
     *
     * @param targetActor The (indirect) actor which is to receive the message.
     * @param request     The (indirect) request.
     */
    final public void _send(ActorFunc targetActor, ObjectFunc request) {
        new _SendFF(this, targetActor, request, null);
    }

    /**
     * Create a _SendFF.
     *
     * @param targetActor The (indirect) actor which is to receive the message.
     * @param request     The (indirect) request.
     * @param resultName  The name of the result, or null.
     */
    final public void _send(ActorFunc targetActor, ObjectFunc request, String resultName) {
        new _SendFF(this, targetActor, request, resultName);
    }

    /**
     * Create a _SendVF.
     *
     * @param targetActor The actor which is to receive the message.
     * @param request     The (indirect) request.
     */
    final public void _send(Actor targetActor, ObjectFunc request) {
        new _SendVF(this, targetActor, request, null);
    }

    /**
     * Create a _SendVF.
     *
     * @param targetActor The actor which is to receive the message.
     * @param request     The (indirect) request.
     * @param resultName  The name of the result, or null.
     */
    final public void _send(Actor targetActor, ObjectFunc request, String resultName) {
        new _SendVF(this, targetActor, request, resultName);
    }

    /**
     * Create a _SendFV.
     *
     * @param targetActor The (indirect) actor which is to receive the message.
     * @param request     The request.
     */
    final public void _send(ActorFunc targetActor, Object request) {
        new _SendFV(this, targetActor, request, null);
    }

    /**
     * Create a _SendFV.
     *
     * @param targetActor The (indirect) actor which is to receive the message.
     * @param request     The request.
     * @param resultName  The name of the result, or null.
     */
    final public void _send(ActorFunc targetActor, Object request, String resultName) {
        new _SendFV(this, targetActor, request, resultName);
    }

    /**
     * Create a_ReturnV.
     *
     * @param result The result returned.
     */
    final public void _return(Object result) {
        new _ReturnV(this, result);
    }

    /**
     * Create a_ReturnF.
     *
     * @param result The indirect result returned.
     */
    final public void _return(ObjectFunc result) {
        new _ReturnF(this, result);
    }

    /**
     * Create a _SetF.
     *
     * @param objectFunc The (indirect) result.
     */
    final public void _set(ObjectFunc objectFunc) {
        new _SetF(this, objectFunc, null);
    }

    /**
     * Create a _SetF.
     *
     * @param objectFunc The (indirect) result.
     * @param resultName The name of the result, or null.
     */
    final public void _set(ObjectFunc objectFunc, String resultName) {
        new _SetF(this, objectFunc, resultName);
    }

    /**
     * Create a _SetV.
     *
     * @param value The result.
     */
    final public void _set(Object value) {
        new _SetV(this, value, null);
    }

    /**
     * Create a _SetV.
     *
     * @param value      The result.
     * @param resultName The name of the result, or null.
     */
    final public void _set(Object value, String resultName) {
        new _SetV(this, value, resultName);
    }

    /**
     * Create an _Iterator.
     *
     * @param iterator The iterator to be executed.
     */
    final public void _iterator(JAIterator iterator) {
        new _Iterator(this, iterator, null);
    }

    /**
     * Create an _Iterator.
     *
     * @param iterator   The iterator to be executed.
     * @param resultName The name of the result, or null.
     */
    final public void _iterator(JAIterator iterator, String resultName) {
        new _Iterator(this, iterator, resultName);
    }

    /**
     * Assign a label to the location of the next operation to be created.
     *
     * @param label The label assigned to the location of the next operation.
     */
    final public void _label(String label) {
        labels.put(label, new Integer(operations.size()));
    }

    /**
     * Create a _Goto.
     *
     * @param label The identifier of where to go to.
     */
    final public void _goto(String label) {
        new _Goto(this, label);
    }

    /**
     * Create an _IfV
     *
     * @param condition The condition.
     * @param label     The identifier of where to go to.
     */
    final public void _if(boolean condition, String label) {
        new _IfV(this, condition, label);
    }

    /**
     * Create an _IfF
     *
     * @param condition The condition.
     * @param label     The identifier of where to go to.
     */
    final public void _if(BooleanFunc condition, String label) {
        new _IfF(this, condition, label);
    }

    /**
     * Create a _Call.
     *
     * @param smb The builder of the state machine to be executed.
     */
    final public void _call(_SMBuilder smb) {
        new _Call(this, smb, null);
    }

    /**
     * Create a _Call.
     *
     * @param smb        The builder of the state machine to be executed.
     * @param resultName The name of the result, or null.
     */
    final public void _call(_SMBuilder smb, String resultName) {
        new _Call(this, smb, resultName);
    }

    /**
     * Instantiate and execute a state machine.
     *
     * @param rp The response processor.
     * @throws Exception Any uncaught exceptions raised while executing the state machine.
     */
    final public void call(ResponseProcessor rp)
            throws Exception {
        final StateMachine stateMachine = new StateMachine(this);
        stateMachine.execute(rp);
    }

    /**
     * Send a request to an actor.
     *
     * @param actor   The target actor.
     * @param request The request.
     * @param rp      The response processor.
     * @throws Exception Any uncaught exceptions raised while processing the request.
     */
    abstract public void send(Actor actor, Object request, ResponseProcessor rp) throws Exception;
}
