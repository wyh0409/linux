CC = gcc
ver = release

CFLAGS = -g -Wall -O0
/*CFLAGS = -Wall -O0*/
OUTPUTNAME = Game


TOPDIR = $(PWD)
BUILDDIR = $(TOPDIR)/build
OBJSDIR = $(BUILDDIR)/obj
BINDIR = $(BUILDDIR)/bin
INCDIR = $(TOPDIR)/include
SOURCEDIR = ./package ./ ./lib

OBJ = main.o\
	  login.o\
	  choose.o\
	  game.o\
	  show.o\
	  gamelist.o
