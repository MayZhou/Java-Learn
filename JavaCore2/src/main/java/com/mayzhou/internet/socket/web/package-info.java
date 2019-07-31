/**
 * {@link java.net.URL}Unfiorm Resource Locator统一资源定位符
 * {@link java.net.URI}Unform Resource Identifier统一资源标识符
 * URI是个纯粹的语法结构，包含用来指定Web资源的字符串的各种组成部分
 * URL是一个特例，它包含了用于定位Web资源的足够信息，它包含了用于定位Web资源的足够信息
 * “mailto:cay@horstmann.com”   则不属于定位符，因为根据该标识符我们无法定位任何数据，称为URN（Uniform Resource name），统一资源名称
 *
 * 绝对路径和相对路径
 * 一个URI具有以下句法
 * [scheme:]schemeSpecificPart[#fragment]
 * 包含scheme部分称为绝对URI
 * 不包含scheme称为相对URI
 * schemeSpecificPart不是以“/”开头，我们就称他不是透明的，例如“mailto:cay@horstmann.com"
 *
 * @author MayZhou
 */
package com.mayzhou.internet.socket.web;